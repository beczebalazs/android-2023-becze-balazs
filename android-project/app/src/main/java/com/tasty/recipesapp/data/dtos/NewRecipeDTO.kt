package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.NewRecipeModel

data class NewRecipeDTO(
    val id: Long,
    val title: String?,
    val description: String?,
    val pictureUrl: String?,
    val videoUrl: String?,
    val ingredients: List<String>?,
    val instructions: List<String>?
)

fun NewRecipeDTO.toModel(): NewRecipeModel {
    return NewRecipeModel(
        id = this.id,
        videoUrl = this.videoUrl,
        title = this.title,
        instructions = this.instructions,
        description = this.description,
        pictureUrl = this.pictureUrl,
        ingredients = this.ingredients
    )
}

fun List<NewRecipeDTO>.toNewRecipeModelList(): List<NewRecipeModel> {
    return this.map { it.toModel() }
}