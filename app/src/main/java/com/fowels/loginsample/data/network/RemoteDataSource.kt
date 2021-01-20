package com.fowels.loginsample.data.network

import com.fowels.loginsample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDataSource {

    companion object {
        private const val BASE_URL = "http://192.168.68.101/laraveloauth2/public/api/"
    }

    fun<Api> buildApi(
        api: Class<Api>,
        authToken: String? = null
    ) : Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().addInterceptor{ chain ->
                    chain.proceed(chain.request().newBuilder().also {
                        it.addHeader("Authorization", "Bearer ${authToken}")
                    }.build())
                }.also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging  = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}