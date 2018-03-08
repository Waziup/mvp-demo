package com.apps.waziup.domain.services.api;


import com.apps.waziup.domain.services.model.HistoricalValue;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface HistoricalDataApi {
    /**
     * Get Historical data for analysis
     *
     * @return Call&lt;HistoricalValue&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("history")
    Observable<HistoricalValue> historyGet();


}
