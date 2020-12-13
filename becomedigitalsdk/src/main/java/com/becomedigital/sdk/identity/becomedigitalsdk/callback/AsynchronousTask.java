package com.becomedigital.sdk.identity.becomedigitalsdk.callback;

import com.becomedigital.sdk.identity.becomedigitalsdk.models.ResponseIV;

public interface AsynchronousTask {
    void onReceiveResultsTransaction(ResponseIV responseIV, int transactionId);
    void onErrorTransaction(String errorMsn);
}
