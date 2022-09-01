package uz.fayyoz.a1shop.data.local.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.fayyoz.a1shop.model.Products

@Dao
interface ProductsDao {

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<Products>>

    @Query("SELECT * FROM products WHERE category == :category")
    fun getProductsByCategory(category: Int): Flow<List<Products>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: List<Products>)

    @Query("Delete from products")
    suspend fun deleteAllProducts()
}