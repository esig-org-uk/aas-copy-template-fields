package uk.org.esig.adobe.libraryDocuments;

import io.swagger.client.api.BaseUrisApi;
import io.swagger.client.api.LibraryDocumentApi;
import io.swagger.client.api.LibraryDocumentsApi;
import io.swagger.client.model.ApiClient;
import io.swagger.client.model.ApiException;
import io.swagger.client.model.agreements.FormField;
import io.swagger.client.model.agreements.FormFieldLocation;
import io.swagger.client.model.baseUris.BaseUriInfo;
import io.swagger.client.model.libraryDocuments.Document;
import io.swagger.client.model.libraryDocuments.Documents;
import io.swagger.client.model.libraryDocuments.FormFields;
import io.swagger.client.model.libraryDocuments.LibraryDocument;

import java.util.List;

public class CopyTemplateFields {
    private static final String API_HOST = "https://api.adobesign.com/";
    private static final String API_PATH = "api/rest/v6";
    private static final String BEARER = "Bearer ";
    private static final int TIMEOUT = 300000;
    private static final String USAGE = "Usage: java -jar aas-copy-template-fields-<version>.jar <integrationKey> <sourceTemplateId> <targetTemplateId>";

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(USAGE);
        } else {
            String accessToken = BEARER + args[0];
            String sourceTemplateId = args[1];
            String targetTemplateId = args[2];
            CopyTemplateFields copy = new CopyTemplateFields();
            try {
                copy.execute(accessToken, sourceTemplateId, targetTemplateId);
            } catch (ApiException ae) {
                System.out.println(getExceptionDetails(ae));
                ae.printStackTrace();
            }
        }
    }

    public void execute(String accessToken, String sourceTemplateId, String targetTemplateId)
            throws ApiException {
        /*
         *  Establish connection to Adobe Sign API, and obtain the correct API Access Point for the account
         */
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(API_HOST + API_PATH);
        apiClient.setConnectTimeout(TIMEOUT).setReadTimeout(TIMEOUT).setWriteTimeout(TIMEOUT);
        BaseUrisApi baseUrisApi = new BaseUrisApi(apiClient);
        BaseUriInfo baseUriInfo = baseUrisApi.getBaseUris(accessToken);
        apiClient.setBasePath(baseUriInfo.getApiAccessPoint() + API_PATH);

        /*
         *  Instantiate APIs
         */
        LibraryDocumentsApi libraryDocumentsApi = new LibraryDocumentsApi(apiClient);
        LibraryDocumentApi libraryDocumentApi = new LibraryDocumentApi(apiClient);

        System.out.println("\nSuccessfully connected to Adobe Acrobat Sign");
        System.out.println("============================================");

        if (targetTemplateId != null) {
            /*
             *  For target template: get document metadata and calculate total number of pages
             */
            Documents documents = libraryDocumentsApi.getDocuments(accessToken, targetTemplateId, null, null, null, null);
            int pageCount = 0;
            if (documents != null && !documents.getDocuments().isEmpty()) {
                for (Document document : documents.getDocuments()) {
                    pageCount = pageCount + document.getNumPages();
                }
            }

            if (pageCount > 0) {
                try {
                    /*
                     *  Get the full set of field definitions from the source template
                     */
                    FormFields sourceFormFields = libraryDocumentApi.getFormFields(accessToken, sourceTemplateId, null, null, null);

                    /*
                     *  Filter out those fields that we don't wish to duplicate
                     */
                    FormFields targetFormFields = filterFormFields(sourceFormFields, pageCount);

                    /*
                     *  Apply the filtered list of fields to the target template
                     */
                    libraryDocumentApi.updateFormFields(accessToken, targetTemplateId, targetFormFields, null, null);
                    System.out.println("Updated template, " + targetTemplateId + ", with filtered field definitions");
                }
                catch (ApiException ae) {
                    System.out.println("Failed to retrieve/update form fields on template: " + targetTemplateId);
                    System.out.println(getExceptionDetails(ae));
                }
            }
        }
    }

    private FormFields filterFormFields(FormFields formFields, int pageCount) {
        FormFields filtered = new FormFields();
        if (formFields != null && formFields.getFormFieldList() != null) {
            for (FormField formField : formFields.getFormFieldList()) {
                boolean skipField = false;
                List<FormFieldLocation> locations = formField.getLocations();
                for (FormFieldLocation loc : locations) {
                    if (loc.getPageNumber() > pageCount || loc.getHeight() < 0.0 || loc.getLeft() < 0.0 || loc.getTop() < 0.0 || loc.getWidth() < 0.0) {
                        skipField = true;
                        break;
                    }
                }
                if (!skipField) {
                    filtered.addFormFieldListItem(formField);
                }
            }
        }
        return filtered;
    }

    private static String getExceptionDetails(ApiException e) {
        StringBuilder sb = new StringBuilder();
        if (e != null) {
            sb.append("Message: ");
            sb.append(e.getMessage());
            sb.append("\n");
            sb.append("Code: ");
            sb.append(e.getCode());
            sb.append("\n");
            sb.append("Response Headers: ");
            sb.append(e.getResponseHeaders());
            sb.append("\n");
            sb.append("Response Body: ");
            sb.append(e.getResponseBody());
        }
        return sb.toString();
    }
}
