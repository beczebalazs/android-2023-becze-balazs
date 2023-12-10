package com.tasty.recipesapp.data.models

data class ComponentModel(
    val rawText: String,
    val extraComment: String?,
    val ingredient: IngredientModel,
    val id: Int,
    val position: Int,
    val measurements: List<MeasurementModel>
)
