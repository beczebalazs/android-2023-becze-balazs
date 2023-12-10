package com.tasty.recipesapp.data.dtos

import com.tasty.recipesapp.data.models.UnitModel

data class UnitDTO(
    val system: String,
    val name: String,
    val display_plural: String,
    val display_singular: String,
    val abbreviation: String
)

fun UnitDTO.toModel(): UnitModel {
    return UnitModel(
        system = this.system,
        name = this.name,
        displayPlural = this.display_plural,
        displaySingular = this.display_singular,
        abbreviation = this.abbreviation
    )
}
