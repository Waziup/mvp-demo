package com.apps.waziup.data.repo.user.local;

import com.apps.waziup.data.model.User;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.reactivex.Observable;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class UserLocal implements UserLocalContract {

    private Box<User> box;
    private List<User> users = new ArrayList<>();

    public UserLocal(BoxStore store){
        box = store.boxFor(User.class);
    }

    @Override
    public Observable<String> getToken() {
        return null;
    }

    @Override
    public Observable<Boolean> saveToken(String token) {
        return null;
    }

    @Override
    public int size() {
        return users.size();
    }
}
