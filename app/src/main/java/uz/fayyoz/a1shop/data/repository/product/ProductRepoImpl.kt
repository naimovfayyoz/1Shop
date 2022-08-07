package uz.fayyoz.a1shop.data.repository.product

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.network.ShopService
import uz.fayyoz.a1shop.utill.BaseNetworkRepo

class ProductRepoImpl(private val shopService: ShopService) : ProductsRepository,
    BaseNetworkRepo() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val productsLiveData: MutableLiveData<List<Products>> = MutableLiveData()
//@TODO set getter

//    override suspend fun getProducts() {
//        coroutineScope.launch {
//            val newsResponse = shopService.getAllProducts()
//            if (newsResponse.isSuccessful) {
//                newsLiveData.postValue(newsResponse.body())
//            }
//        }
//    }

    override fun getByCategory(id: Int): MutableLiveData<List<Products>> {
        coroutineScope.launch {
            val productsResponse = shopService.getByCategory(id)
            if (productsResponse.isSuccessful) {
                productsLiveData.postValue(productsResponse.body())
            }
        }
        return productsLiveData
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