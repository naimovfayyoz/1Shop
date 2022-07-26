package uz.fayyoz.a1shop.ui.category.vm

import uz.fayyoz.a1shop.domain.GetByCategoryUseCase
import uz.fayyoz.a1shop.ui.BaseViewModel

class CategoryVM(private val getByCategoryUseCase: GetByCategoryUseCase) : BaseViewModel() {

    //    private val _products =
//        MutableStateFlow<Resource<PagingData<Products>>>(Resource.InitialState())
//    val products = _products.asStateFlow()

    fun getByCategory(id: Int) = getByCategoryUseCase.execute(id)

}