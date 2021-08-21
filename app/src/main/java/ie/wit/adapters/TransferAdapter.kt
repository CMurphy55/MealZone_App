package ie.wit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.R
import ie.wit.models.TransferModel
import kotlinx.android.synthetic.main.card_donation.view.*
import kotlinx.android.synthetic.main.card_donation.view.calorieAmount
import kotlinx.android.synthetic.main.fragment_home.view.*

//transferAdapter File
class TransferAdapter constructor(var donations: ArrayList<TransferModel>)
    : RecyclerView.Adapter<TransferAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_donation,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val donation = donations[holder.adapterPosition]
        holder.bind(donation)
    }

    override fun getItemCount(): Int = donations.size

    fun removeAt(position: Int) {
        donations.removeAt(position)
        notifyItemRemoved(position)
    }

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(meal: TransferModel) {
            itemView.tag = meal._id
            itemView.calorieAmount.text = meal.calories
            itemView.description.text = meal.description
            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}