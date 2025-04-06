package com.example.jetsnack.api

import com.example.jetsnack.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("/pokemon/{id}")
    suspend fun getPokemonsList(

        @Query("api_key") key : String
    ): Response<List<Pokemon>>


    //fun getPokemon(@Query("key") key : String): Response<List<Pokemon>>
    //@POST("https://pokeapi.co/api/v2/pokemon/{id}")
    //fun createPokemon(@Body pokemon: Pokemon): Response<CreatePokemonResponse>
}