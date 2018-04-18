package com.apps.waziup.data.repo.user;

import com.apps.waziup.data.model.AuthBody;
import com.apps.waziup.data.repo.user.local.UserLocalContract;
import com.apps.waziup.data.repo.user.remote.UserRemoteContract;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/3/2018.
 */

public class UserRepo implements UserRepoContract {

    private UserLocalContract local;
    private UserRemoteContract remote;

    public UserRepo(UserLocalContract local, UserRemoteContract remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public Observable<String> logUserIn(AuthBody request) {
        return this.remote.getToken(request);
    }

    @Override
    public Observable<Boolean> saveToken(String token) {
        return local.saveToken(token);
    }
}
