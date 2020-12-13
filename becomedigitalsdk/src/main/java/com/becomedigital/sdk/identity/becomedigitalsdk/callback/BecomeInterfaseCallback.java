package com.becomedigital.sdk.identity.becomedigitalsdk.callback;


import com.becomedigital.sdk.identity.becomedigitalsdk.models.InfoTarjeta;

public interface BecomeInterfaseCallback {
    void onSuccess(InfoTarjeta responseIV);
    void onCancel();
    void onError(LoginError pLoginError);
}
