import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel

class RecipeAdapter(
    private var recipes: List<RecipeModel>,
    private val onItemClick: (RecipeModel) -> Unit,
    private val onDetailsClick: (RecipeModel) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]

        val imageView = holder.itemView.findViewById<ImageView>(R.id.recipeImage)
        val textView = holder.itemView.findViewById<TextView>(R.id.recipeName)

        Picasso.get().load(recipe.thumbnailUrl).into(imageView)

        textView.text = recipe.name

        holder.itemView.setOnClickListener {
            onItemClick(recipe)
        }

        holder.itemView.findViewById<Button>(R.id.detailsButton).setOnClickListener {
            onDetailsClick(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun updateData(newRecipes: List<RecipeModel>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}