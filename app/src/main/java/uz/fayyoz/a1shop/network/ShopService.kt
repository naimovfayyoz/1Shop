package uz.fayyoz.a1shop.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.fayyoz.a1shop.Model.Products

interface ShopService {

    @GET("products")
    suspend fun getAllProducts(): Response<List<Products>>

    @GET("categories/{categoryID}/products")
    suspend fun getByCategory(@Path("categoryID") id: Int): Response<List<Products>>

    //@GET("categories")
//    suspend fun getByCategory()
}