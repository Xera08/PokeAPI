package com.example.jetsnack.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


object RetrofitInstance {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


    val api: PokemonApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(PokemonApi.BASE_URL)
        .client(client)
        .build()
        .create(PokemonApi::class.java)
}