package uz.fayyoz.a1shop.ui.fragment.category.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.domain.GetByCategoryUseCase
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.ui.BaseViewModel

class CategoryVM(private val getByCategoryUseCase: GetByCategoryUseCase) : BaseViewModel() {

    private val _productsLiveData: MutableLiveData<List<Products>> = MutableLiveData()
    val productsLiveData: LiveData<List<Products>> get() = _productsLiveData

    fun getByCategory(id: Int): LiveData<List<Products>> {
        viewModelScope.launch(exceptionHandler) {
            val productsResponse = getByCategoryUseCase.execute(id)
            if (productsResponse.isSuccessful) {
                _productsLiveData.postValue(productsResponse.body())
            }
        }
        return productsLiveData
    }
}


//    private val _products =
//        MutableStateFlow<Resource<PagingData<Products>>>(Resource.InitialState())
//    val products = _products.asStateFlow()