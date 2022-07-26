package uz.fayyoz.a1shop.domain

import retrofit2.Response
import uz.fayyoz.a1shop.Model.Products
import uz.fayyoz.a1shop.repository.ProductsRepository

class GetByCategoryUseCase(private val repository: ProductsRepository) {

    fun execute(
        id: Int,
    ) = repository.getByCategory(id)
}