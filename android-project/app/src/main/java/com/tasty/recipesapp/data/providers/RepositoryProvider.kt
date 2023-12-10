package com.tasty.recipesapp.data.providers
import com.tasty.recipesapp.repositories.instruction.InstructionsRepository

object RepositoryProvider {
    val instructionsRepository: InstructionsRepository = InstructionsRepository()
}