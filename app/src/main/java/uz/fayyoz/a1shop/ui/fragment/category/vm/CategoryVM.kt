package uz.fayyoz.a1shop.ui.fragment.category.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.domain.GetByCategoryUseCase
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.ui.BaseViewModel
import uz.fayyoz.a1shop.utill.Resource

class CategoryVM(private val getByCategoryUseCase: GetByCategoryUseCase) : BaseViewModel() {

    fun getByCategory(id: Int): LiveData<Resource<List<Products>>> =
        getByCategoryUseCase.execute(id).asLiveData()


//
//    fun getByCategory(id: Int): LiveData<List<Products>> {
//        viewModelScope.launch(exceptionHandler) {
//            val productsResponse = getByCategoryUseCase.execute(id)
//            if (productsResponse.isSuccessful) {
//                _productsLiveData.postValue(productsResponse.body())
//            }
//        }
//        return productsLiveData
//    }
}


//    private val _products =
//        MutableStateFlow<Resource<PagingData<Products>>>(Resource.InitialState())
//    val products = _products.asStateFlow()