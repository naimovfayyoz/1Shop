package uz.fayyoz.a1shop.repository

import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.model.Token
import uz.fayyoz.a1shop.model.User
import uz.fayyoz.a1shop.utill.Resource

interface ProductsRepository {

    // suspend fun getProducts()

    fun getByCategory(id: Int): MutableLiveData<List<Products>>

    suspend fun login(email: String, password: String): Resource<Response<Token>>

    fun cancelJob()
}