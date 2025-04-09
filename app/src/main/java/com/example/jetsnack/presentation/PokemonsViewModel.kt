package com.example.jetsnack.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsnack.api.PokemonsRepository
import com.example.jetsnack.api.Result
import com.example.jetsnack.model.Pokemon
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonsViewModel(
    private val pokemonsRepository: PokemonsRepository
): ViewModel() {
    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons = _pokemons.asStateFlow()


    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            pokemonsRepository.getPokemonList().collectLatest { result ->
                when(result) {
                    is Result.Error<*> -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Success<*> -> {
                        result.data?.let { pokemons ->
                            _pokemons.update {pokemons}
                        }
                    }
                }
            }

        }

    }




}