package uz.fayyoz.a1shop.di

import uz.fayyoz.a1shop.repository.ProductRepoImpl
import uz.fayyoz.a1shop.repository.ProductsRepository

object RepositoryModule {

    fun bindProductsRepo(): ProductsRepository = ProductRepoImpl(
        RetrofitService.shopService
    )
}