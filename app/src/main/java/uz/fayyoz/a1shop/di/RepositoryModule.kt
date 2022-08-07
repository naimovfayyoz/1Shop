package uz.fayyoz.a1shop.di

import uz.fayyoz.a1shop.data.local.pref.UserPref
import uz.fayyoz.a1shop.data.repository.login.LoginRepoImpl
import uz.fayyoz.a1shop.data.repository.login.LoginRepository
import uz.fayyoz.a1shop.data.repository.product.ProductRepoImpl
import uz.fayyoz.a1shop.data.repository.product.ProductsRepository
import uz.fayyoz.a1shop.data.repository.signUp.SignUpRepoImpl
import uz.fayyoz.a1shop.data.repository.signUp.SignUpRepository
import uz.fayyoz.a1shop.utill.App

object RepositoryModule {

    fun bindProductsRepo(): ProductsRepository = ProductRepoImpl(
        RetrofitService.shopService
    )

    fun bindLoginRepo(): LoginRepository = LoginRepoImpl(
        RetrofitService.shopService,
        UserPref(App.appInstance)
    )

    fun bindSignUpRepo():SignUpRepository=SignUpRepoImpl(
        RetrofitService.shopService
    )
}