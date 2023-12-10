package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.IngredientModel

data class IngredientDTO(
    val created_at: Long,
    val display_plural: String,
    val id: Int,
    val display_singular: String,
    val updated_at: Long,
    val name: String
)

fun IngredientDTO.toModel(): IngredientModel {
    return IngredientModel(
        createdAt = this.created_at,
        displayPlural = this.display_plural,
        id = this.id,
        displaySingular = this.display_singular,
        updatedAt = this.updated_at,
        name = this.name
    )
}
