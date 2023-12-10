package com.tasty.recipesapp.data.models

data class InstructionModel(
    val appliance: String?,
    val endTime: Int,
    val temperature: Int?,
    val id: Int,
    val position: Int,
    val displayText: String,
    val startTime: Int
)
