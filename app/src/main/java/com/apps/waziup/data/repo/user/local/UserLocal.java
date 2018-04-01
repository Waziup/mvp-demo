package com.apps.waziup.data.repo.user.local;

import android.content.Context;

import com.apps.waziup.data.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class UserLocal implements UserLocalContract {

    private List<User> users = new ArrayList<>();

    public UserLocal(Context context){
//        users =
    }

    @Override
    public Observable<String> getToken() {
        return null;
    }

    @Override
    public Observable<Boolean> saveToken() {
        return null;
    }

    @Override
    public int size() {
        return users.size();
    }
}
