package com.example.aviatickets.model.network

import com.example.aviatickets.model.entity.Flight
import com.example.aviatickets.model.entity.Offer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {

//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://my-json-server.typicode.com/estharossa/fake-api-demo")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//

    interface ApiService {
        @GET("offer_list")
        fun getOffers(): List<Offer>
    }

    interface ApiService2 {
        @GET("offer_list/flight")
        fun getOffers(): List<Flight>
    }

    /**
     * think about performing network request
     */
}