package ie.project.models;

interface TransferStore {

    fun findAll() : List<MealModel>
    fun findById(id: String) : MealModel?
    fun create(meal: MealModel)
    fun update(meal: MealModel)
    fun delete(meal: MealModel)

}