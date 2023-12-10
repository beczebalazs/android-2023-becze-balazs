package com.tasty.recipesapp.repositories.recipe

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.data.dtos.RecipesDTO
import com.tasty.recipesapp.data.dtos.toModelList
import com.tasty.recipesapp.data.models.RecipeModel
import java.io.IOException

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.java.canonicalName

    fun getRecipes(context: Context): List<RecipeModel> {
        var jsonString: String = ""

        try {
            jsonString = context.assets.open("recipes.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioExeption: IOException) {
            Log.e(TAG, "Error occurred while reading JSON file: $ioExeption")
        }

        val recipesResponse: RecipesDTO =
            Gson().fromJson(jsonString, object : TypeToken<RecipesDTO>() {}.type)

        return recipesResponse.results.toModelList()
    }
}