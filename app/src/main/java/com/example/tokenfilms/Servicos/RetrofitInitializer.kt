package com.example.tokenfilms.Servicos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://desafio-mobile.nyc3.digitaloceanspaces.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun moviesService():RetrofitService = retrofit.create(RetrofitService::class.java)

}