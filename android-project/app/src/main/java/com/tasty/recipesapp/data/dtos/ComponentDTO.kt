package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.ComponentModel

data class ComponentDTO(
    val raw_text: String,
    val extra_comment: String? = null,
    val ingredient: IngredientDTO,
    val id: Int,
    val position: Int,
    val measurements: List<MeasurementDTO>
)

fun ComponentDTO.toModel(): ComponentModel {
    return ComponentModel(
        rawText = this.raw_text,
        extraComment = this.extra_comment,
        ingredient = this.ingredient.toModel(),
        id = this.id,
        position = this.position,
        measurements = this.measurements.toModelList()
    )
}

fun List<ComponentDTO>.toModelList(): List<ComponentModel> =
    this.map { it.toModel() }