package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.NutritionModel

data class NutritionDTO(
    val fiber: Int,
    val updated_at: String,
    val protein: Int,
    val fat: Int,
    val calories: Int,
    val sugar: Int,
    val carbohydrates: Int
)

fun NutritionDTO.toModel(): NutritionModel {
    return NutritionModel(
        fiber = this.fiber,
        updatedAt = this.updated_at,
        protein = this.protein,
        fat = this.fat,
        calories = this.calories,
        sugar = this.sugar,
        carbohydrates = this.carbohydrates
    )
}
