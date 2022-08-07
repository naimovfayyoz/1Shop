package uz.fayyoz.a1shop.data.repository.product

import androidx.lifecycle.MutableLiveData
import uz.fayyoz.a1shop.model.Products

interface ProductsRepository {

    // suspend fun getProducts()

    fun getByCategory(id: Int): MutableLiveData<List<Products>>


    fun cancelJob()
}