package uz.fayyoz.a1shop.di

import androidx.room.Room
import kotlinx.serialization.ExperimentalSerializationApi
import uz.fayyoz.a1shop.data.local.db.AppDatabase
import uz.fayyoz.a1shop.data.local.db.ProductsDao
import uz.fayyoz.a1shop.utill.App

object DatabaseModule {

    private val database = provideDatabase()

    @OptIn(ExperimentalSerializationApi::class)
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(App.appInstance, AppDatabase::class.java, "uz.fayyoz.shop_db")
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun provideProductsDao(): ProductsDao {
        return database.productsDao()
    }


}