package ie.project.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class DonationMemStore : TransferStore {

    var donations = ArrayList<MealModel>()

        override fun findAll(): List<MealModel> {
            return donations
        }

        override fun findById(id:String) : MealModel? {
            val foundDonation: MealModel? = donations.find { it._id == id }
            return foundDonation
        }

        override fun create(donation: MealModel) {
            //donation._id = getId()
            donations.add(donation)
            logAll()
        }

        override fun update(donation: MealModel) {

        }

        override fun delete(donation: MealModel) {
            donations.remove(donation)
            logAll()
        }

        fun logAll() {
            Log.v("Donate","** Donations List **")
            donations.forEach { Log.v("Donate","${it}") }
        }
    }
