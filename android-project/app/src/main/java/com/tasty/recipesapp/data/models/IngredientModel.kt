package com.tasty.recipesapp.data.models

data class IngredientModel(
    val createdAt: Long,
    val displayPlural: String,
    val id: Int,
    val displaySingular: String,
    val updatedAt: Long,
    val name: String
)

