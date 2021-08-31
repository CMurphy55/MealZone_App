package ie.project.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.project.R
import ie.project.models.MealModel
import kotlinx.android.synthetic.main.recyclerview_cards.view.*
import kotlinx.android.synthetic.main.recyclerview_cards.view.calorieAmount

//transferAdapter File
class TransferAdapter constructor(var meals: ArrayList<MealModel>)
    : RecyclerView.Adapter<TransferAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_cards,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val donation = meals[holder.adapterPosition]
        holder.bind(donation)
    }

    override fun getItemCount(): Int = meals.size

    fun removeAt(position: Int) {
        meals.removeAt(position)
        notifyItemRemoved(position)
    }

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(meal: MealModel) {
            Log.wtf("tag", "$meal")
            itemView.tag = meal._id
            itemView.calorieAmount.text = meal.calories
            itemView.description.text = meal.description
            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}