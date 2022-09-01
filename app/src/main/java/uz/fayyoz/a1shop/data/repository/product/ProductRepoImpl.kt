package uz.fayyoz.a1shop.data.repository.product

import retrofit2.Response
import uz.fayyoz.a1shop.data.local.db.ProductsDao
import uz.fayyoz.a1shop.data.remote.ShopService
import uz.fayyoz.a1shop.utill.BaseNetworkRepo
import uz.fayyoz.a1shop.utill.networkBoundResource

class ProductRepoImpl(
    private val shopService: ShopService,
    private val productsDao: ProductsDao,
) : ProductsRepository,
    BaseNetworkRepo() {
    override fun getByCategory(id: Int) = networkBoundResource(
        query = { productsDao.getProductsByCategory(id) },
        fetch = {
            shopService.getByCategory(id)
        },
        saveFetchResult = {
            productsDao.deleteAllProducts()
            productsDao.saveProducts(it)
        }
    )

}

//    override suspend fun getProducts() {
//        coroutineScope.launch {
//            val newsResponse = shopService.getAllProducts()
//            if (newsResponse.isSuccessful) {
//                newsLiveData.postValue(newsResponse.body())
//            }
//        }
//    }