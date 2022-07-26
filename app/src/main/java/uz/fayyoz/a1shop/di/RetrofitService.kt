package uz.fayyoz.a1shop.di

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.fayyoz.a1shop.network.ShopService
import java.util.concurrent.TimeUnit

object RetrofitService {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            chain.run {
                proceed(request())
                    .newBuilder()
                    .build()
            }
        }.build()

    private val retrofit: Retrofit =
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .build()

    val shopService: ShopService = retrofit.create(ShopService::class.java)
}