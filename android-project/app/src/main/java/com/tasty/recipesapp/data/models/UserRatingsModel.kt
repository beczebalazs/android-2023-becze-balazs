package com.tasty.recipesapp.data.models

data class UserRatingsModel(
    val countNegative: Int,
    val countPositive: Int,
    val score: Double
)
