package ie.project.main

import android.app.Application
import ie.project.api.MealService
import ie.project.models.MealJSONStore
import ie.project.models.MealModel
import ie.project.models.TransferStore

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class TransferApp : Application(), AnkoLogger {

    //lateinit var donationsStore: DonationMemStore
    lateinit var mealService: MealService
    var donations = ArrayList<MealModel>()
    lateinit var meals : TransferStore

    override fun onCreate() {
        super.onCreate()
        info("Starting")
        mealService = MealService.create()
        meals = MealJSONStore(applicationContext)
        info("Meal Created")
    }
}