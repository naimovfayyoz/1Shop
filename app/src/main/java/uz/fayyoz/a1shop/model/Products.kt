package uz.fayyoz.a1shop.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Products(
    @PrimaryKey
    val id:Int,
    val category: Int,
    val description: String,
    val image: String,
    val images: List<String>,
    val price: Double,
    val title: String,
    var isFavorite: Boolean = false,
)
