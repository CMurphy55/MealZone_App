package ie.project.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ie.project.R
import ie.project.main.MealRepository
import ie.project.models.MealModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.enterButton
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import javax.security.auth.callback.Callback

class HomeFragment : Fragment(), AnkoLogger, Callback {

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.enterButton.setOnClickListener {
            val description = view.AddDescription.text.toString()
            val calories = view.calories.text.toString()

            if (description.isNotEmpty() && calories.isNotEmpty()) {
                addAMeal(description, calories)
            } else {
                showErrorMessage(description, calories)
            }
        }

//        btnMaps.setOnClickListener{
//            val map = MapFragment()
//            val transaction : FragmentTransaction = fragmentManager!!.beginTransaction()
//            transaction.replace(R.layout.fragment_home,Map_fragment)
//            transaction.commit()
//        }
        return view
    }

    private fun addAMeal(description: String, calories: String) {
        Log.wtf("TAG", "$description  $calories")
        MealRepository.meals.add(MealModel(description = description, calories = calories))
        activity?.toast("You have entered a meal into the application!")
    }

    private fun showErrorMessage(description: String, calories: String) {
        when {
            description.isEmpty() -> activity?.toast("Enter a description!!")
            calories.isEmpty() -> activity?.toast("Enter calories!!")
        }
    }
}





