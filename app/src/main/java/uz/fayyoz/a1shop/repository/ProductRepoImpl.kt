package uz.fayyoz.a1shop.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.Model.Products
import uz.fayyoz.a1shop.network.ShopService

class ProductRepoImpl(private val shopService: ShopService) : ProductsRepository {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val newsLiveData: MutableLiveData<List<Products>> = MutableLiveData()

    override suspend fun getProducts() {
        coroutineScope.launch {
            val newsResponse = shopService.getAllProducts()
            if (newsResponse.isSuccessful) {
                newsLiveData.postValue(newsResponse.body())
            }
        }
    }

    override  fun getByCategory(id: Int) {
        coroutineScope.launch {
            val newsResponse = shopService.getByCategory(id)
            if (newsResponse.isSuccessful) {
                newsLiveData.postValue(newsResponse.body())
            }
        }
    }

    override fun cancelJob() {
        coroutineScope.cancel()
    }
}