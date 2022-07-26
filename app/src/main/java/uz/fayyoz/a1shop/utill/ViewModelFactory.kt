package uz.fayyoz.a1shop.utill

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.fayyoz.a1shop.di.RepositoryModule
import uz.fayyoz.a1shop.domain.GetByCategoryUseCase
import uz.fayyoz.a1shop.ui.category.vm.CategoryVM

class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val productRepo = RepositoryModule.bindProductsRepo()
        return CategoryVM(GetByCategoryUseCase(productRepo)) as T
    }
}