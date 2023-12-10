package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.InstructionModel

data class InstructionDTO(
    val appliance: String?,
    val end_time: Int,
    val temperature: Int?,
    val id: Int,
    val position: Int,
    val display_text: String,
    val start_time: Int
)

fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        appliance = this.appliance,
        endTime = this.end_time,
        temperature = this.temperature,
        id = this.id,
        position = this.position,
        displayText = this.display_text,
        startTime = this.start_time
    )
}

fun List<InstructionDTO>.toModelList(): List<InstructionModel> =
    this.map { it.toModel() }
