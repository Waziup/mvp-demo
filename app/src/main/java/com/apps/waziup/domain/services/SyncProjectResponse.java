package com.apps.waziup.domain.services;

import com.apps.waziup.model.Project;


public class SyncProjectResponse {
    public final SyncResponseEventType eventType;
    public final Project project;

    public SyncProjectResponse(SyncResponseEventType eventType, Project project) {
        this.eventType = eventType;
        this.project = project;
    }
}
