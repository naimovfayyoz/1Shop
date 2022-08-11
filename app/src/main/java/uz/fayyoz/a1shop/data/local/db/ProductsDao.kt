package uz.fayyoz.a1shop.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.fayyoz.a1shop.model.Category
import uz.fayyoz.a1shop.model.Products

@Dao
interface ProductsDao {

    @Query("SELECT * FROM products WHERE category == :category")
    fun getProductsById(category: Int): Flow<List<Products>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: List<Products>)

}