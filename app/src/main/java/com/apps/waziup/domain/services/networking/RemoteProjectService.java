package com.apps.waziup.domain.services.networking;


import com.apps.waziup.domain.services.api.DomainsApi;
import com.apps.waziup.domain.services.api.SensorsApi;
import com.apps.waziup.domain.services.auth.ApiKeyAuth;
import com.apps.waziup.domain.services.model.Domain;
import com.apps.waziup.domain.services.model.Location;
import com.apps.waziup.domain.services.model.Sensor;
import com.apps.waziup.helper.ResponseUtil;
import com.apps.waziup.model.Device;
import com.apps.waziup.model.Project;
import com.apps.waziup.waziup.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

//import java.util.Observable;

public final class RemoteProjectService {

    private static RemoteProjectService instance;

    private final Retrofit retrofit;

    public RemoteProjectService() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        ApiKeyAuth appKeyAuthInterceptor = new ApiKeyAuth("header", "bearer");


        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(appKeyAuthInterceptor)
                .build();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized RemoteProjectService getInstance() {
        if (instance == null) {
            instance = new RemoteProjectService();
        }
        return instance;
    }

    public Project addProjectDomain(Project project) throws IOException, RemoteException {
        DomainsApi service = retrofit.create(DomainsApi.class);

        Domain d = new Domain();
        d.setId(project.getName());

        // Remote call can be executed synchronously since the job calling it is already backgrounded.
        return service.domainsPost(d)
                .filter(response -> response != null && response.isSuccessful() && response.errorBody() != null)
                .flatMapSingle(response -> {

                    //if (response == null || !response.isSuccessful() || response.errorBody() != null) {
                    //    return Single.
                    //}

                    Timber.d("successful remote response: " + response.body());

                    if (response.code() == 201) {
                        String location = response.headers().get("location");
                        if (location != null && !location.isEmpty()) {
                            Timber.d("Location header: " + location);
                            URI uri = new URI(location);
                            String path = uri.getPath();
                            String idStr = path.substring(path.lastIndexOf('/') + 1);
                            return service.domainsDomainGet(idStr)
                                    .map(domain -> new Project());
                        }
                    }

                    return Single.error(new RemoteException(response));
                })
                .blockingGet();
                /*
                .subscribe( locResp -> {
                            if (locResp == null || !locResp.isSuccessful() || locResp.errorBody() != null) {
                                throw new RemoteException(locResp);
                            }
                        }
                , err -> {
                        Timber.e(err);
                        });
                        */

    }

    public Device addProjectDevice(Project project, Device device) throws IOException, RemoteException {
        SensorsApi service = retrofit.create(SensorsApi.class);

        String domainName = project.getName();
        Sensor s = new Sensor();
        s.domain(domainName)
                .gatewayId("")
                .location(new Location().latitude(device.getLatitude()).longitude(device.getLongitude()))
                .name(device.getName())
        //.addMeasurementsItem(new Measurement().)
        ;


        // Remote call can be executed synchronously since the job calling it is already backgrounded.
        return service.domainsDomainSensorsPost(s, domainName)
                .filter(ResponseUtil::isValidResponse)
                .flatMapSingle(response -> {

                    Timber.d("successful remote response: " + response.body());

                    return ResponseUtil.getLocationData(response,
                            id -> service.domainsDomainSensorsSensorIdGet(domainName, id))
                            .map(ss -> new Device());

                })
                .blockingGet();


    }

    public List<Device> getProjectDevices(String domainName) throws IOException, RemoteException {
        SensorsApi service = retrofit.create(SensorsApi.class);

        // Remote call can be executed synchronously since the job calling it is already backgrounded.
        //https://stackoverflow.com/questions/44509728/android-rxjava2-retrofit2-chaining-calls-with-pagination-token
        final AtomicReference<Integer> limit = new AtomicReference<>(0);
        final Integer offset = 20;
        return service.domainsDomainSensorsGet(domainName, "", limit.toString(), offset.toString())
                //.doOnNext(ls -> {
                //    if(ls.isEmpty()) {
                //        limit.set(-1);
                //    }
                //    else {
                //        limit.set(limit.get() + offset);
                //    }

                //})
                //.repeatWhen(r -> r.takeWhile(rr -> limit.get() > 0))
                .flatMap(ls -> Observable.fromIterable(ls.stream().map(s -> new Device()).collect(Collectors.toCollection(ArrayList::new))))
                .toList()
                .blockingGet();

    }
}
