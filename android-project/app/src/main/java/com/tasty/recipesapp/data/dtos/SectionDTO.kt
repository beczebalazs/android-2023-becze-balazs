package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.SectionModel

data class SectionDTO(
    val components: List<ComponentDTO>? = null,
    val name: String? = null,
    val position: Int
)

fun SectionDTO.toModel(): SectionModel {
    return SectionModel(
        components = this.components?.toModelList() ?: emptyList(),
        name = this.name,
        position = this.position
    )
}

fun List<SectionDTO>.toModelList(): List<SectionModel> =
    this.map { it.toModel() }

