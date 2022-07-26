package uz.fayyoz.a1shop.repository

interface ProductsRepository {

    suspend fun getProducts()

     fun getByCategory(id: Int)

    fun cancelJob()
}