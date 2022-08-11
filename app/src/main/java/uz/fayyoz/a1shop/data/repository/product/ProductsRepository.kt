package uz.fayyoz.a1shop.data.repository.product

import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import uz.fayyoz.a1shop.model.Products

interface ProductsRepository {

    // suspend fun getProducts()

    suspend fun getByCategory(id: Int): Response<List<Products>>

}