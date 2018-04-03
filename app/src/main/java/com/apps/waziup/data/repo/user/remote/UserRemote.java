package com.apps.waziup.data.repo.user.remote;

import android.content.Context;

import com.apps.waziup.data.model.AuthBody;
import com.apps.waziup.data.repo.BaseRemote;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class UserRemote extends BaseRemote implements UserRemoteContract {

    public UserRemote(Context context) {
        super(context, "user");
    }

    @Override
    public Observable<String> getToken(AuthBody body) {
        return BaseRemote.userService.login(body);
    }
}
