package com.apps.waziup.domain.services;

import com.apps.waziup.model.Project;
import com.jakewharton.rxrelay2.PublishRelay;

import io.reactivex.Observable;

public class SyncProjectRxBus {

    private static SyncProjectRxBus instance;
    private final PublishRelay<SyncProjectResponse> relay;

    private SyncProjectRxBus() {
        relay = PublishRelay.create();
    }

    public static synchronized SyncProjectRxBus getInstance() {
        if (instance == null) {
            instance = new SyncProjectRxBus();
        }
        return instance;
    }

    public void post(SyncResponseEventType eventType, Project comment) {
        relay.accept(new SyncProjectResponse(eventType, comment));
    }

    public Observable<SyncProjectResponse> toObservable() {
        return relay;
    }
}
