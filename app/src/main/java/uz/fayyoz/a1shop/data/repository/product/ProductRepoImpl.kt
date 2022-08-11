package uz.fayyoz.a1shop.data.repository.product

import kotlinx.coroutines.flow.Flow
import uz.fayyoz.a1shop.data.local.db.ProductsDao
import uz.fayyoz.a1shop.data.remote.ShopService
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.utill.BaseNetworkRepo
import uz.fayyoz.a1shop.utill.NetworkBoundResource
import uz.fayyoz.a1shop.utill.Resource

class ProductRepoImpl(
    private val shopService: ShopService,
    private val productsDao: ProductsDao,
) : ProductsRepository,
    BaseNetworkRepo() {

    override suspend fun getByCategory(id: Int)= object : NetworkBoundResource<List<Products>, List<Products>>()
    {
        override fun fetchFromLocal(): Flow<List<Products>> {
return productsDao.getProductsById(id)       }

        override fun fetchFromRemote(): Flow<Resource<List<Products>>> {
            TODO("Not yet implemented")
        }

        override suspend fun saveRemoteData(data: List<Products>) {
            TODO("Not yet implemented")
        }

        override fun shouldFetchFromRemote(data: List<Products>): Boolean {
            TODO("Not yet implemented")
        }

    }


}

//    override suspend fun getProducts() {
//        coroutineScope.launch {
//            val newsResponse = shopService.getAllProducts()
//            if (newsResponse.isSuccessful) {
//                newsLiveData.postValue(newsResponse.body())
//            }
//        }
//    }