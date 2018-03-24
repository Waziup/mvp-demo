package com.apps.waziup.domain.services.networking;

import retrofit2.Response;

public class RemoteException extends android.os.RemoteException {

    private final Response response;

    public RemoteException(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
