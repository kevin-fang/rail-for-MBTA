package com.helionlabs.kfang.rail.api

import com.helionlabs.kfang.rail.models.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kfang on 7/21/17.
 */

interface MbtaApi {

    @GET("/developer/api/v2/schedulebyroute?api_key=wX9NwuHnZU2ToO7GmGR9uw&format=json&max_trips=100&max_time=1440")
    fun getBoundSchedule(@Query("route") routeName: String, @Query("datetime") epoch: Long, @Query("direction") inbound: Int) : Observable<Response>
}
