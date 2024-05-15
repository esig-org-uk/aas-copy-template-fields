package io.swagger.client.model.libraryDocuments;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.agreements.FormField;

import java.util.ArrayList;
import java.util.List;

public class FormFields {
    @SerializedName("fields")
    private List<FormField> formFieldList = null;

    public FormFields formFieldList(List<FormField> formFieldList) {
        this.formFieldList = formFieldList;
        return this;
    }

    public FormFields addFormFieldListItem(FormField formFieldListItem) {
        if (this.formFieldList == null) {
            this.formFieldList = new ArrayList<FormField>();
        }
        this.formFieldList.add(formFieldListItem);
        return this;
    }

    @ApiModelProperty(value = "An array of libraryDocument form fields")
    public List<FormField> getFormFieldList() {
        return formFieldList;
    }
}
