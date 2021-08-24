package ie.project.api

import com.google.gson.GsonBuilder
import ie.project.models.MealModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface MealService {
    @GET("/donations")
    fun getall(): Call<List<MealModel>>

    @GET("/donations/{id}")
    fun get(@Path("id") id: String): Call<MealModel>

    @DELETE("/donations/{id}")
    fun delete(@Path("id") id: String): Call<TransferWrapper>

    @POST("/donations")
    fun post(@Body donation: MealModel): Call<TransferWrapper>

    @PUT("/donations/{id}")
    fun put(@Path("id") id: String,
            @Body donation: MealModel
    ): Call<TransferWrapper>

    companion object {

        val serviceURL = "https://donationweb-hdip-server.herokuapp.com"

        fun create() : MealService {

            val gson = GsonBuilder().create()

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(serviceURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
            return retrofit.create(MealService::class.java)
        }
    }
}