package io.swagger.client.api;

import com.google.gson.reflect.TypeToken;
import io.swagger.client.model.ApiCallback;
import io.swagger.client.model.ApiClient;
import io.swagger.client.model.ApiException;
import io.swagger.client.model.ApiResponse;
import io.swagger.client.model.Configuration;
import io.swagger.client.model.Pair;
import io.swagger.client.model.ProgressRequestBody;
import io.swagger.client.model.ProgressResponseBody;
import io.swagger.client.model.libraryDocuments.FormFields;
import io.swagger.client.model.libraryDocuments.LibraryDocument;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDocumentApi {
    private ApiClient apiClient;

    public LibraryDocumentApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LibraryDocumentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getFormFields
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFormFieldsCall(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/libraryDocuments/{libraryDocumentId}/formFields"
                .replaceAll("\\{" + "libraryDocumentId" + "\\}", apiClient.escapeString(libraryDocumentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
            localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (xApiUser != null)
            localVarHeaderParams.put("x-api-user", apiClient.parameterToString(xApiUser));
        if (xOnBehalfOfUser != null)
            localVarHeaderParams.put("x-on-behalf-of-user", apiClient.parameterToString(xOnBehalfOfUser));
        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFormFieldsValidateBeforeCall(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling getFormData(Async)");
        }

        // verify the required parameter 'libraryDocumentId' is set
        if (libraryDocumentId == null) {
            throw new ApiException("Missing the required parameter 'libraryDocumentId' when calling getFormData(Async)");
        }


        com.squareup.okhttp.Call call = getFormFieldsCall(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Retrieves data entered into the interactive form fields of the library document.
     * This API can only be called by the creator of the library document
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @return byte[]
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormFields getFormFields(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch) throws ApiException {
        ApiResponse<FormFields> resp = getFormFieldsWithHttpInfo(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch);
        return resp.getData();
    }

    /**
     * Retrieves data entered into the interactive form fields of the library document.
     * This API can only be called by the creator of the library document
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @return ApiResponse&lt;byte[]&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<FormFields> getFormFieldsWithHttpInfo(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch) throws ApiException {
        com.squareup.okhttp.Call call = getFormFieldsValidateBeforeCall(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch, null, null);
        Type localVarReturnType = new TypeToken<FormFields>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieves data entered into the interactive form fields of the library document. (asynchronously)
     * This API can only be called by the creator of the library document
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFormFieldsAsync(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch, final ApiCallback<byte[]> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFormFieldsValidateBeforeCall(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<byte[]>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for getLibraryDocument
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getLibraryDocumentCall(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/libraryDocuments/{libraryDocumentId}"
                .replaceAll("\\{" + "libraryDocumentId" + "\\}", apiClient.escapeString(libraryDocumentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
            localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (xApiUser != null)
            localVarHeaderParams.put("x-api-user", apiClient.parameterToString(xApiUser));
        if (xOnBehalfOfUser != null)
            localVarHeaderParams.put("x-on-behalf-of-user", apiClient.parameterToString(xOnBehalfOfUser));
        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getLibraryDocumentValidateBeforeCall(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling getLibraryDocument(Async)");
        }

        // verify the required parameter 'libraryDocumentId' is set
        if (libraryDocumentId == null) {
            throw new ApiException("Missing the required parameter 'libraryDocumentId' when calling getLibraryDocument(Async)");
        }


        com.squareup.okhttp.Call call = getLibraryDocumentCall(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Retrieves the library document.
     *
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @return byte[]
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LibraryDocument getLibraryDocument(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch) throws ApiException {
        ApiResponse<LibraryDocument> resp = getLibraryDocumentWithHttpInfo(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch);
        return resp.getData();
    }

    /**
     * Retrieves the library document.
     *
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @return ApiResponse&lt;byte[]&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LibraryDocument> getLibraryDocumentWithHttpInfo(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch) throws ApiException {
        com.squareup.okhttp.Call call = getLibraryDocumentValidateBeforeCall(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch, null, null);
        Type localVarReturnType = new TypeToken<LibraryDocument>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieves the library document. (asynchronously)
     *
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;library_read&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;library_read&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param ifNoneMatch Pass the value of the e-tag header obtained from the previous response to the same request to get a RESOURCE_NOT_MODIFIED(304) if the resource hasn&#39;t changed. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getLibraryDocumentAsync(String authorization, String libraryDocumentId, String xApiUser, String xOnBehalfOfUser, String ifNoneMatch, final ApiCallback<byte[]> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getLibraryDocumentValidateBeforeCall(authorization, libraryDocumentId, xApiUser, xOnBehalfOfUser, ifNoneMatch, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LibraryDocument>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for updateFormFields
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;agreement_write&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param formFields List of form fields to add or replace (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateFormFieldsCall(String authorization, String libraryDocumentId, FormFields formFields, String xApiUser, String xOnBehalfOfUser, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = formFields;

        // create path and map variables
        String localVarPath = "/libraryDocuments/{libraryDocumentId}/formFields"
                .replaceAll("\\{" + "libraryDocumentId" + "\\}", apiClient.escapeString(libraryDocumentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
            localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (xApiUser != null)
            localVarHeaderParams.put("x-api-user", apiClient.parameterToString(xApiUser));
        if (xOnBehalfOfUser != null)
            localVarHeaderParams.put("x-on-behalf-of-user", apiClient.parameterToString(xOnBehalfOfUser));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateFormFieldsValidateBeforeCall(String authorization, String libraryDocumentId, FormFields formFields, String xApiUser, String xOnBehalfOfUser, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling updateFormFields(Async)");
        }

        // verify the required parameter 'libraryDocmentId' is set
        if (libraryDocumentId == null) {
            throw new ApiException("Missing the required parameter 'libraryDocumentId' when calling updateFormFields(Async)");
        }

        // verify the required parameter 'formFieldPutInfo' is set
        if (formFields == null) {
            throw new ApiException("Missing the required parameter 'formFieldPutInfo' when calling updateFormFields(Async)");
        }


        com.squareup.okhttp.Call call = updateFormFieldsCall(authorization, libraryDocumentId, formFields, xApiUser, xOnBehalfOfUser, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates form fields of an agreement.  This will replace all fields in AUTHORING mode agreements, and will replace all fields except for text tag generated fields in DRAFT mode agreements.
     *
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;agreement_write&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param formFields List of form fields to add or replace (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @return AgreementFormFields
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormFields updateFormFields(String authorization, String libraryDocumentId, FormFields formFields, String xApiUser, String xOnBehalfOfUser) throws ApiException {
        ApiResponse<FormFields> resp = updateFormFieldsWithHttpInfo(authorization, libraryDocumentId, formFields, xApiUser, xOnBehalfOfUser);
        return resp.getData();
    }

    /**
     * Updates form fields of an agreement.  This will replace all fields in AUTHORING mode agreements, and will replace all fields except for text tag generated fields in DRAFT mode agreements.
     *
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;agreement_write&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param formFields List of form fields to add or replace (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @return ApiResponse&lt;AgreementFormFields&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<FormFields> updateFormFieldsWithHttpInfo(String authorization, String libraryDocumentId, FormFields formFields, String xApiUser, String xOnBehalfOfUser) throws ApiException {
        com.squareup.okhttp.Call call = updateFormFieldsValidateBeforeCall(authorization, libraryDocumentId, formFields, xApiUser, xOnBehalfOfUser, null, null);
        Type localVarReturnType = new TypeToken<FormFields>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates form fields of an agreement.  This will replace all fields in AUTHORING mode agreements, and will replace all fields except for text tag generated fields in DRAFT mode agreements. (asynchronously)
     *
     * @param authorization An &lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc()\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;OAuth Access Token&lt;/a&gt; with scopes:&lt;ul&gt;&lt;li style&#x3D;&#39;list-style-type: square&#39;&gt;&lt;a href&#x3D;\&quot;#\&quot; onclick&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; oncontextmenu&#x3D;\&quot;this.href&#x3D;oauthDoc(&#39;agreement_write&#39;)\&quot; target&#x3D;\&quot;oauthDoc\&quot;&gt;agreement_write&lt;/a&gt;&lt;/li&gt;&lt;/ul&gt;in the format &lt;b&gt;&#39;Bearer {accessToken}&#39;. (required)
     * @param libraryDocumentId The document identifier, as retrieved from the API to fetch library documents. (required)
     * @param formFields List of form fields to add or replace (required)
     * @param xApiUser The userId or email of API caller using the account or group token in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; If it is not specified, then the caller is inferred from the token. (optional)
     * @param xOnBehalfOfUser The userId or email in the format &lt;b&gt;userid:{userId} OR email:{email}.&lt;/b&gt; of the user that has shared his/her account (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFormFieldsAsync(String authorization, String libraryDocumentId, FormFields formFields, String xApiUser, String xOnBehalfOfUser, final ApiCallback<FormFields> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateFormFieldsValidateBeforeCall(authorization, libraryDocumentId, formFields, xApiUser, xOnBehalfOfUser, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormFields>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
