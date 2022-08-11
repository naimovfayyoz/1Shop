package uz.fayyoz.a1shop.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uz.fayyoz.a1shop.model.Category
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.model.User
import uz.fayyoz.a1shop.utill.ListTypeConverter


@Database(entities = [User::class, Products::class, Category::class], version = 1)
@TypeConverters(ListTypeConverter::class)
@kotlinx.serialization.ExperimentalSerializationApi
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null
        fun getDatabaseInstance(context: Context): AppDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java, "shop_db"
            )
                .fallbackToDestructiveMigration()
                .build().also {
                    instance = it
                }
        }
    }
}