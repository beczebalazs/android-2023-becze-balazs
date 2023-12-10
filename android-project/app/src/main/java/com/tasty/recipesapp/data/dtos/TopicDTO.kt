package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.TopicModel

data class TopicDTO(
    val name: String,
    val slug: String
)

fun TopicDTO.toModel(): TopicModel {
    return TopicModel(
        name = this.name,
        slug = this.slug
    )
}

fun List<TopicDTO>.toModelList(): List<TopicModel> =
    this.map { it.toModel() }
