import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.repositories.recipe.RecipeRepository
import com.tasty.recipesapp.data.models.RecipeModel

class RecipeViewModel : ViewModel(){

    private val repository = RecipeRepository

    var recipeList: MutableLiveData<List<RecipeModel>> = MutableLiveData()
    var instructionList: MutableLiveData<List<InstructionModel>> = MutableLiveData()

    fun readAllRecipes(context: Context) {
        val recipes = RecipeRepository.getRecipes(context)
        recipeList.value = recipes
    }

    fun fetchRecipeData(context: Context){
        recipeList.value = repository.getRecipes(context)
    }

}