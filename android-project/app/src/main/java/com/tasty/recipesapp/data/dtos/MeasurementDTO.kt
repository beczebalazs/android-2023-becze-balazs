package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.MeasurementModel

data class MeasurementDTO(
    val unit: UnitDTO,
    val quantity: String,
    val id: Int
)

fun MeasurementDTO.toModel(): MeasurementModel {
    return MeasurementModel(
        unit = this.unit.toModel(),
        quantity = this.quantity,
        id = this.id
    )
}

fun List<MeasurementDTO>.toModelList(): List<MeasurementModel> =
    this.map { it.toModel() }
