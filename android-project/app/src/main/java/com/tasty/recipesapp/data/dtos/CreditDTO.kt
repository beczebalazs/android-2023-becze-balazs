package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.CreditModel
data class CreditDTO(
    val name: String?,
    val type: String
)

fun CreditDTO.toModel(): CreditModel {
    return CreditModel(
        name = this.name ?: "DefaultName",
        type = this.type
    )
}

fun List<CreditDTO>.toModelList(): List<CreditModel> =
    this.map { it.toModel() }
