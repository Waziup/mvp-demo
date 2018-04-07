package com.apps.waziup.helper;


import com.apps.waziup.domain.services.networking.RemoteException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.function.Function;

import io.reactivex.Single;
import retrofit2.Response;


public class ResponseUtil {

    public static boolean isValidResponse(Response response) {
        return response != null && response.isSuccessful() && response.errorBody() != null;
    }

    public static Optional<URI> getLocationUri(Response response) {

        try {
            if (isValidResponse(response) && response.code() == 201) {
                String location = response.headers().get("location");
                if (location != null && !location.isEmpty()) {
                    URI uri = new URI(location);
                    return Optional.of(uri);
                }

            }
        } catch (URISyntaxException exception) {
            return Optional.empty();
        }

        return Optional.empty();

    }

    public static Optional<String> getLocationPathId(Response response) {
        return getLocationUri(response).map(u -> {
            String path = u.getPath();
            String idStr = path.substring(path.lastIndexOf('/') + 1);
            return idStr;
        });

    }

    public static <T> Single<T> getLocationData(Response response, Function<String, Single<T>> getApiCall) {

        //TODO: Wrong response is being handled in error
        //TODO: Wrong response is being handled in error
        return getLocationPathId(response)
                .map(getApiCall)
                .orElse(Single.error(new RemoteException(response)));


    }

}

