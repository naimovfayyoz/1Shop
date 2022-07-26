package uz.fayyoz.a1shop.repository

import androidx.lifecycle.MutableLiveData
import uz.fayyoz.a1shop.Model.Products

interface ProductsRepository {

    suspend fun getProducts()

    fun getByCategory(id: Int): MutableLiveData<List<Products>>

    fun cancelJob()
}