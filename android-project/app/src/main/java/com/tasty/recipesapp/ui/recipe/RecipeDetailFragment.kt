package com.tasty.recipesapp.ui.recipe

import RecipeAdapter
import RecipeViewModel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.InstructionModel

class RecipeDetailFragment : Fragment() {

    private lateinit var recipeAdapter: RecipeAdapter
    private val TAG: String? = "RecipesDetailedFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        val imageView = view.findViewById<ImageView>(R.id.recipeImage)


        val recipeId = arguments?.getString("recipeId")

        Log.d("detailt", "${recipeId}")
        val text = view.findViewById<TextView>(R.id.recipeName)
        val description = view.findViewById<TextView>(R.id.recipeDescription)
        val instructionsText = view.findViewById<TextView>(R.id.instructionsText)
        text.text = recipeId

        context?.let {
            viewModel.fetchRecipeData(it)
        }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                if (recipe.name == recipeId) {
                    Log.d(TAG, "Recipe name: ${recipe.name}")
                    Log.d(TAG, "Recipe description: ${recipe.description}")
                    description.text = recipe.description
                    Log.d(TAG, "Recipe image: ${recipe.thumbnailUrl}")
                    Picasso.get().load(recipe.thumbnailUrl).into(imageView)
                    val recipeInstructions = recipe.instructions
                    val instructionText = buildInstructionText(recipeInstructions)
                    instructionsText.text = instructionText
                    val nutrition = recipe.nutrition
                    if (nutrition != null) {
                        Log.d(
                            TAG,
                            "Nutrition - Fiber: ${nutrition.fiber}, Protein: ${nutrition.protein}, " +
                                    "Fat: ${nutrition.fat}, Calories: ${nutrition.calories}, " +
                                    "Sugar: ${nutrition.sugar}, Carbohydrates: ${nutrition.carbohydrates}"
                        )
                    } else {
                        Log.d(TAG, "Nutrition is null for this recipe.")
                    }
                    val instructions = recipe.instructions
                    if (instructions.isNotEmpty()) {
                        Log.d(TAG, "Instructions:")
                        for (instruction in instructions) {
                            Log.d(TAG, "- ${instruction.displayText}")
                        }
                    } else {
                        Log.d(TAG, "No instructions for this recipe.")
                    }
                    val credits = recipe.credits
                    if (credits?.isNotEmpty() == true) {
                        Log.d(TAG, "Credits:")
                        for (credit in credits) {
                            Log.d(TAG, "- Name: ${credit.name}, Type: ${credit.type}")
                        }
                    } else {
                        Log.d(TAG, "No credits for this recipe.")
                    }

                    val components = recipe.components
                    if (components.isNotEmpty()) {
                        Log.d(TAG, "Components:")
                        for (component in components) {
                            Log.d(
                                TAG,
                                "- Raw Text: ${component.rawText}, Extra Comment: ${component.extraComment}"
                            )
                        }
                    } else {
                        Log.d(TAG, "No components for this recipe.")
                    }

                    val sections = recipe.sections
                    if (sections.isNotEmpty()) {
                        Log.d(TAG, "Sections:")
                        for (section in sections) {
                            val componentsInSection = section.components
                            if (componentsInSection.isNotEmpty()) {
                                Log.d(TAG, "Components in Section:")
                                for (componentInSection in componentsInSection) {
                                    Log.d(
                                        TAG,
                                        "-- Raw Text: ${componentInSection.rawText}, Extra Comment: ${componentInSection.extraComment}"
                                    )

                                    val ingredient = componentInSection.ingredient
                                    Log.d(
                                        TAG,
                                        "--- Ingredient: Name: ${ingredient.name}, ID: ${ingredient.id}, Display Singular: ${ingredient.displaySingular}, " +
                                                "Display Plural: ${ingredient.displayPlural}, Created At: ${ingredient.createdAt}, Updated At: ${ingredient.updatedAt}"
                                    )

                                    val measurements = componentInSection.measurements
                                    if (measurements.isNotEmpty()) {
                                        Log.d(TAG, "--- Measurements:")
                                        for (measurement in measurements) {
                                            Log.d(
                                                TAG,
                                                "---- Quantity: ${measurement.quantity}, Unit: Name: ${measurement.unit.name}, " +
                                                        "Abbreviation: ${measurement.unit.abbreviation}, Display Singular: ${measurement.unit.displaySingular}, " +
                                                        "Display Plural: ${measurement.unit.displayPlural}, System: ${measurement.unit.system}"
                                            )
                                        }
                                    } else {
                                        Log.d(TAG, "--- No Measurements for this component.")
                                    }
                                }
                            } else {
                                Log.d(TAG, "No components in this section.")
                            }
                        }
                    } else {
                        Log.d(TAG, "No sections for this recipe.")
                    }

                    val tags = recipe.tags
                    if (tags.isNotEmpty()) {
                        Log.d(TAG, "Tags:")
                        for (tag in tags) {
                            Log.d(
                                TAG,
                                "- Root Tag Type: ${tag.rootTagType}, Name: ${tag.name}, ID: ${tag.id}, Display Name: ${tag.displayName}, Type: ${tag.type}"
                            )
                        }
                    } else {
                        Log.d(TAG, "No tags for this recipe.")
                    }

                    val topics = recipe.topics
                    if (topics.isNotEmpty()) {
                        Log.d(TAG, "Topics:")
                        for (topic in topics) {
                            Log.d(TAG, "- Name: ${topic.name}, Slug: ${topic.slug}")
                        }
                    } else {
                        Log.d(TAG, "No topics for this recipe.")
                    }

                    val userRatings = recipe.userRatings
                    Log.d(
                        TAG, "User Ratings - Count Negative: ${userRatings.countNegative}, " +
                                "Count Positive: ${userRatings.countPositive}, " +
                                "Score: ${userRatings.score}"
                    )

                    Log.d(TAG, "-----------------------------------------")
                }
            }

        }
    }
    private fun buildInstructionText(instructions: List<InstructionModel>): String {
        val stringBuilder = StringBuilder()
        for ((index, instruction) in instructions.withIndex()) {
            val numberedInstruction = "${index + 1}. ${instruction.displayText}"
            stringBuilder.append(numberedInstruction)
            if (index < instructions.size - 1) {
                stringBuilder.append("\n")
            }
        }
        return stringBuilder.toString()
    }
}