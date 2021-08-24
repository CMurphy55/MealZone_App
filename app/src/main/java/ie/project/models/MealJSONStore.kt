package ie.project.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ie.project.utils.exists
import ie.project.utils.read
import ie.project.utils.write
import org.jetbrains.anko.AnkoLogger
import java.lang.reflect.Type
import java.util.*

const val JSON_FILE = "Meals.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType : Type = object : TypeToken<java.util.ArrayList<MealModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class MealJSONStore (val context: Context) : TransferStore, AnkoLogger {

    private var meals = mutableListOf<MealModel>()

    init {
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<MealModel> {
        return meals
    }

    override fun findById(id: String): MealModel? {
        TODO("Not yet implemented")
    }

    override fun create(meal: MealModel) {

        meals.add(meal)
        serialize()
    }

    override fun update(meal: MealModel) {
        val MealsList = findAll() as ArrayList<MealModel>
        var foundMeal: MealModel? = MealsList.find { p -> p._id == meal._id }
        if (foundMeal != null) {
            foundMeal.description = meal.description
            foundMeal.calories = meal.calories

        }
        serialize()
    }

    override fun delete(meal: MealModel) {
        TODO("Not yet implemented")
    }



    private fun serialize() {
        val jsonString = gsonBuilder.toJson(meals, listType)
        write (context, JSON_FILE, jsonString)
    }



    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        meals = Gson().fromJson(jsonString, listType)
    }
}


