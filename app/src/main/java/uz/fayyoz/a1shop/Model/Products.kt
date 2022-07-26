package uz.fayyoz.a1shop.Model

data class Products(
    val category: Category,
    val description: String,
    val id: Int,
    val image: String,
    val images: List<String>,
    val price: Double,
    val title: String,
)