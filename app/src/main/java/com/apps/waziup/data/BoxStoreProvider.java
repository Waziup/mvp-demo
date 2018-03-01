package com.apps.waziup.data;

import android.content.Context;

import io.objectbox.BoxStore;

/**
 * Class used for storing the BoxStore.
 */
public class BoxStoreProvider {

    private static BoxStore store;

    public static BoxStore getStore() {
        if (store == null) {
            throw new RuntimeException("BoxStore was not initialized!");
        }
        return store;
    }

    public static void create(Context context) {
        store = MyObjectBox.builder().androidContext(context).build();
    }
}
