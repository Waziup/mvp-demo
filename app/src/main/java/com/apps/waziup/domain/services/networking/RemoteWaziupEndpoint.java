package com.apps.waziup.domain.services.networking;

import com.apps.waziup.model.Project;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface RemoteWaziupEndpoint {

    @POST("/domains")
    Call<Project> addProject(@Body Project project);
}
