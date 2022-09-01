package uz.fayyoz.a1shop.domain

import uz.fayyoz.a1shop.data.repository.product.ProductsRepository

class GetByCategoryUseCase(private val repository: ProductsRepository) {

     fun execute(
        id: Int,
    ) = repository.getByCategory(id)
}