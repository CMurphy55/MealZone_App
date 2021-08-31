package ie.project.main

import android.app.Application
import ie.project.models.MealJSONStore
import ie.project.models.MealModel
import ie.project.models.TransferStore

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class TransferApp : Application(), AnkoLogger {

    lateinit var meals: TransferStore

    override fun onCreate() {
        super.onCreate()
        meals = MealJSONStore(applicationContext)
        info("Application has started")
    }

}