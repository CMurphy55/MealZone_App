package ie.project.models;

interface TransferStore {

    fun findAll() : List<TransferModel>
    fun findById(id: String) : TransferModel?
    fun create(meal: TransferModel)
    fun update(meal: TransferModel)
    fun delete(meal: TransferModel)

}