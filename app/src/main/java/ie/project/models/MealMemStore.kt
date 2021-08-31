package ie.project.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class MealMemStore : TransferStore {

    val meals = ArrayList<MealModel>()

    override fun findAll(): List<MealModel> {
        return meals
    }

    override fun findById(id:String) : MealModel? {
        val foundDonation: MealModel? = meals.find { it._id == id }
        return foundDonation
    }

    override fun create(donation: MealModel) {
        //donation._id = getId()
        meals.add(donation)
        logAll()
    }

    override fun update(meal: MealModel) {
        var mealSave: MealModel? = meals.find { p -> p._id == meal._id }
        if (mealSave != null) {
            mealSave.calories = meal.calories
            mealSave.description = meal.description
            mealSave.image = meal.image

            logAll();
        }
    }

    override fun delete(donation: MealModel) {
        meals.remove(donation)
        logAll()
    }

    fun logAll() {
        Log.v("Donate","** Donations List **")
        meals.forEach { Log.v("Donate","${it}") }
    }
}