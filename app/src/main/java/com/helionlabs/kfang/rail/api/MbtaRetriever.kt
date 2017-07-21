package com.helionlabs.kfang.rail.api

import com.helionlabs.kfang.rail.models.Response
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kfang on 7/21/17.
 */
class MbtaRetriever {
    private val service: MbtaApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://realtime.mbta.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        service = retrofit.create(MbtaApi::class.java)
    }

    fun getBoundedCommuterSchedule(routeName: String, time: Long, bound: Int): Observable<Response> = service.getBoundSchedule(routeName, time, bound)

    companion object {
        val INBOUND = 1
        val OUTBOUND = 0
    }
}