package com.apps.waziup.data.repo.user.remote;

import com.apps.waziup.data.model.AuthBody;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface UserRemoteContract {

    Observable<String> getToken(AuthBody body);
}
