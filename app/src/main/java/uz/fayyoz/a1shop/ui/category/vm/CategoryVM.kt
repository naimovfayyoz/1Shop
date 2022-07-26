package uz.fayyoz.a1shop.ui.category.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.Model.Products
import uz.fayyoz.a1shop.di.RepositoryModule
import uz.fayyoz.a1shop.domain.GetByCategoryUseCase
import uz.fayyoz.a1shop.repository.ProductsRepository
import uz.fayyoz.a1shop.ui.BaseViewModel
import uz.fayyoz.a1shop.utill.Resource

class CategoryVM(private val getByCategoryUseCase: GetByCategoryUseCase) : BaseViewModel() {

    //    private val _products =
//        MutableStateFlow<Resource<PagingData<Products>>>(Resource.InitialState())
//    val products = _products.asStateFlow()

    fun getByCategory(id: Int) = getByCategoryUseCase.execute(id)

}