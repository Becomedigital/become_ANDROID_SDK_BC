package com.becomedigital.sdk.identity.becomedigitalsdk;

import android.app.Application;

public class MyApplication extends Application {
    protected String access_token;
    protected boolean isVerification;
    protected String resourceUrl;
    protected String clientId;
    protected String clientSecret;
    protected String contractId;
    protected String validationTypes;
    protected String user_id;
    protected boolean allowLibraryLoading;
    protected String urlVideo;
    protected String urlDocFront;
    protected String urlDocBack;
    protected String selectedCountry;
    protected String selectedCountyCo2;
    protected byte[] dataToTransfer;

    public enum typeDocument {
        DNI,
        PASSPORT,
        LICENSE
    }

    protected typeDocument selectedDocument;

    public boolean isVerification() {
        return isVerification;
    }

    public void setVerification(boolean verification) {
        isVerification = verification;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getValidationTypes() {
        return validationTypes;
    }

    public void setValidationTypes(String validationTypes) {
        this.validationTypes = validationTypes;
    }

    public boolean isAllowLibraryLoading() {
        return allowLibraryLoading;
    }

    public void setAllowLibraryLoading(boolean allowLibraryLoading) {
        this.allowLibraryLoading = allowLibraryLoading;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public boolean getIsVerification() {
        return this.isVerification;
    }

    public void setIsVerification(boolean z) {
        this.isVerification = z;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public void setResourceUrl(String str) {
        this.resourceUrl = str;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUrlDocFront() {
        return urlDocFront;
    }

    public void setUrlDocFront(String urlDocFront) {
        this.urlDocFront = urlDocFront;
    }

    public String getUrlDocBack() {
        return urlDocBack;
    }

    public void setUrlDocBack(String urlDocBack) {
        this.urlDocBack = urlDocBack;
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public typeDocument getSelectedDocument() {
        return selectedDocument;
    }

    public void setSelectedDocument(typeDocument selectedDocument) {
        this.selectedDocument = selectedDocument;
    }

    public String getSelectedCountyCo2() {
        return selectedCountyCo2;
    }

    public void setSelectedCountyCo2(String selectedCountyCo2) {
        this.selectedCountyCo2 = selectedCountyCo2;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public byte[] getDataToTransfer() {
        return dataToTransfer;
    }

    public void setDataToTransfer(byte[] dataToTransfer) {
        this.dataToTransfer = dataToTransfer;
    }

    public void onCreate() {
        super.onCreate ( );
    }
}
