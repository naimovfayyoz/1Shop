package uz.fayyoz.a1shop.repository

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.model.User
import uz.fayyoz.a1shop.network.ShopService
import uz.fayyoz.a1shop.utill.BaseNetworkRepo

class ProductRepoImpl(private val shopService: ShopService) : ProductsRepository,
    BaseNetworkRepo() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val newsLiveData: MutableLiveData<List<Products>> = MutableLiveData()

//    override suspend fun getProducts() {
//        coroutineScope.launch {
//            val newsResponse = shopService.getAllProducts()
//            if (newsResponse.isSuccessful) {
//                newsLiveData.postValue(newsResponse.body())
//            }
//        }
//    }

    override suspend fun login(email: String, password: String) = safeApiCall {
        shopService.login(email, password)
    }
    override fun getByCategory(id: Int): MutableLiveData<List<Products>> {
        coroutineScope.launch {
            val newsResponse = shopService.getByCategory(id)
            if (newsResponse.isSuccessful) {
                newsLiveData.postValue(newsResponse.body())
            }
        }
        return newsLiveData
    }

//    override fun createUser() {
//        coroutineScope.launch {
//            shopService.login(
//                "john@mail.com",
//                "changeme",
//            )
//        }
//    }


    override fun cancelJob() {
        coroutineScope.cancel()
    }
}