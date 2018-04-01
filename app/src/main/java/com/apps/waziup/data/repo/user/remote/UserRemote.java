package com.apps.waziup.data.repo.user.remote;

import com.apps.waziup.data.repo.BaseRemote;
import com.apps.waziup.domain.services.model.AuthBody;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class UserRemote implements UserRemoteContract {

    @Override
    public Observable<String> getToken(AuthBody body) {
        return BaseRemote.userService.login(body);
    }
}
