package com.apps.waziup.data.repo.user;

import com.apps.waziup.data.model.AuthBody;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/3/2018.
 */

public interface UserRepoContract {

    Observable<String> logUserIn(AuthBody request);

    Observable<Boolean> saveToken(String token);

}
