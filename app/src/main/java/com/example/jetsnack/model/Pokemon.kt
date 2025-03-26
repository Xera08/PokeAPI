package com.example.jetsnack.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.jetsnack.R

@Immutable
data class Pokemon(
    val id: Short,
    val name: String,
    @DrawableRes
    val imageRes: Int,
    val firstMove: String,
    val secondMove: String
)

var pokemons = listOf(
    Pokemon(
        id = 1337,
        name = "Test pokemon",
        imageRes = R.drawable.cupcake,
        firstMove = "Allah",
        secondMove = "Akbar"
        )
)