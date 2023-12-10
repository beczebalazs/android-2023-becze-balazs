package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.data.models.UserRatingsModel

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description!",
    val instructions: List<InstructionDTO>? = null,
    val nutrition: NutritionDTO? = null,
    val credits: List<CreditDTO>? = null,
    val components: List<ComponentDTO>? = null,
    val sections: List<SectionDTO>? = null,
    val tags: List<TagDTO>? = null,
    val topics: List<TopicDTO>? = null,
    val userRatings: UserRatingsDTO? = null,
    val thumbnail_url: String? = null
)

fun RecipeDTO.toModel() : RecipeModel {
    return RecipeModel(
        name = this.name,
        description = this.description,
        instructions = this.instructions?.toModelList() ?: emptyList(),
        nutrition = this.nutrition?.toModel() ,
        credits = this.credits?.toModelList() ?: emptyList(),
        components = this.components?.toModelList() ?: emptyList(),
        sections = this.sections?.toModelList() ?: emptyList(),
        tags = this.tags?.toModelList() ?: emptyList(),
        topics = this.topics?.toModelList() ?: emptyList(),
        userRatings = this.userRatings?.toModel() ?: UserRatingsModel(0, 0, 0.0),
        thumbnailUrl = this.thumbnail_url
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }
