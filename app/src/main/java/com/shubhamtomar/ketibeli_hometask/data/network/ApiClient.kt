package com.shubhamtomar.ketibeli_hometask.data.network


import com.shubhamtomar.ketibeli_hometask.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {


    private fun getRetrofit(baseUrl: String): Retrofit {

        val loggingInterceptor = run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

        val client: OkHttpClient = if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .apply {
                    readTimeout(120, TimeUnit.SECONDS)
                    connectTimeout(120, TimeUnit.SECONDS)
                    addInterceptor(loggingInterceptor)
                }
                .build()
        } else {
            OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    val ketiBeliApi: ApiService by lazy {
        getRetrofit(BuildConfig.BASE_URL).create(ApiService::class.java)
    }


}