package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.TagModel

data class TagDTO(
    val root_tag_type: String,
    val name: String,
    val id: Int,
    val display_name: String,
    val type: String
)

fun TagDTO.toModel(): TagModel {
    return TagModel(
        rootTagType = this.root_tag_type,
        name = this.name,
        id = this.id,
        displayName = this.display_name,
        type = this.type
    )
}

fun List<TagDTO>.toModelList(): List<TagModel> =
    this.map { it.toModel() }