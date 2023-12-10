package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.UserRatingsModel

data class UserRatingsDTO(
    val count_negative: Int,
    val count_positive: Int,
    val score: Double
)

fun UserRatingsDTO.toModel(): UserRatingsModel {
    return UserRatingsModel(
        countNegative = this.count_negative,
        countPositive = this.count_positive,
        score = this.score
    )
}
