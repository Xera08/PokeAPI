package com.example.jetsnack.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val api: PokemonApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .build(PokemonApi::class.java)
    }

}

object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}