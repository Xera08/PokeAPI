package com.example.jetsnack.api

import com.example.jetsnack.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {
    suspend fun getPokemonList(): Flow<Result<List<Pokemon>>>

}