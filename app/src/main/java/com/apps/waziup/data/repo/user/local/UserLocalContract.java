package com.apps.waziup.data.repo.user.local;

import com.apps.waziup.data.model.User;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface UserLocalContract {

    Observable<String> getToken();

    /**
     * saves user in db and returns true if saved and false if not
     * @return boolean
     */
    Observable<Boolean> saveToken();

    int size();
}
