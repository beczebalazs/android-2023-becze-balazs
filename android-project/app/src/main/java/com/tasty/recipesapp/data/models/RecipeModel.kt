package com.tasty.recipesapp.data.models

data class RecipeModel(
    val name: String,
    val description: String? = "Default description!",
    val instructions: List<InstructionModel>,
    val nutrition: NutritionModel?,
    val credits: List<CreditModel>,
    val components: List<ComponentModel>,
    val sections: List<SectionModel>,
    val tags: List<TagModel>,
    val topics: List<TopicModel>,
    val userRatings: UserRatingsModel,
    val thumbnailUrl: String?
)