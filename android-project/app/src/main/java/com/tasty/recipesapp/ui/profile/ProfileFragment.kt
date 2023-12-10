package com.tasty.recipesapp.ui.profile
import RecipeAdapter
import RecipeViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R


class ProfileFragment : Fragment() {
    private lateinit var recipeAdapter: RecipeAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(RecipeViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        context?.let {
            viewModel.fetchRecipeData(it)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.profileRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recipeAdapter = RecipeAdapter(emptyList(), onItemClick = {}, onDetailsClick = {})
        recyclerView.adapter = recipeAdapter

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            Log.d("ProfileFragment", "Observing recipe list changes")
            val randomRecipes = recipes.shuffled().take(3)

            recipeAdapter.updateData(randomRecipes)
        }
    }
}