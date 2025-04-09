package com.example.jetsnack.api

import com.example.jetsnack.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class PokemonsRepositoryImpl (
    private val api: PokemonApi
): PokemonsRepository {
    override suspend fun getPokemonList(): Flow<Result<List<Pokemon>>> {
        return flow{
            val pokemonsFromApi = try {
                api.getPokemonsList()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading pokemons"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading pokemons"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading pokemons"))
                return@flow
            }
            emit(Result.Success(pokemonsFromApi.pokemons))
        }
    }
}
