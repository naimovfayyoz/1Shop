package uz.fayyoz.a1shop.ui.category.vm

import uz.fayyoz.a1shop.di.RepositoryModule
import uz.fayyoz.a1shop.repository.ProductsRepository
import uz.fayyoz.a1shop.ui.BaseViewModel

class CategoryVM : BaseViewModel() {

    private val productsRepository: ProductsRepository = RepositoryModule.bindProductsRepo()

}