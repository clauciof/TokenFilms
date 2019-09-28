package com.example.tokenfilms.Servicos

import com.example.tokenfilms.Models.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("movies")
    fun get_all_movies(): Call<List<Filme>>

    @GET("movies/{id}")
    fun get_movie_detail( @Path("id") id: Int): Call<Filme>
}