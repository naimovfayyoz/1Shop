package uz.fayyoz.a1shop.data.repository.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.utill.Resource

interface ProductsRepository {

    // suspend fun getProducts()

     fun getByCategory(id: Int): Flow<Resource<List<Products>>>

}