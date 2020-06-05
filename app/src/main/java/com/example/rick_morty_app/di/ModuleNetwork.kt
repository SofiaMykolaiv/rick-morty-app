package com.example.rick_morty_app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL_RICK_MORTY = "https://rickandmortyapi.com/"

// Provide Network
private const val PROVIDE_BASE_URL = "base_url"
private const val PROVIDE_CONVERTER_FACTORY = "gson_converter_factory"
private const val PROVIDE_OKHTTP_CLIENT = "okhttp_client"
private const val PROVIDE_GSON = "gson"

val networkModule = module {
    single(named(PROVIDE_BASE_URL)) { BASE_URL_RICK_MORTY }
    single(named(PROVIDE_GSON)) { provideGson() }
    single(named(PROVIDE_OKHTTP_CLIENT)) { provideOkHttpClient() }
    single(named(PROVIDE_CONVERTER_FACTORY)) { provideGsonConverterFactory(get(named(PROVIDE_GSON))) }
    single {
        provideRetrofit(
            get(named(PROVIDE_BASE_URL)),
            get(named(PROVIDE_CONVERTER_FACTORY)),
            get(named(PROVIDE_OKHTTP_CLIENT))
        )
    }
}

private fun provideGson(): Gson = GsonBuilder().create()

private fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
    GsonConverterFactory.create(gson)

private fun provideOkHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.addInterceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .build()
        chain.proceed(request)
    }
    return client.build()
}

private fun provideRetrofit(
    baseUrl: String,
    gsonConverterFactory: GsonConverterFactory,
    client: OkHttpClient
): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .client(client)
        .build()