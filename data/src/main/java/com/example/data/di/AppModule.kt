package com.example.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.common.Constants
import com.example.domain.repository.TmdbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideTmdbApi(@ApplicationContext context: Context): com.example.data.remote.TmdbApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(com.example.data.remote.TmdbApi::class.java)
    }

    @Provides
    fun provideTmdbRepository(api: com.example.data.remote.TmdbApi): TmdbRepository {
        return com.example.data.repository.TmdbRepositoryImpl(api)
    }

    @Provides
    fun provideUserDataStoreManager(@ApplicationContext context: Context): com.example.data.local.UserDataStoreManager {
        return com.example.data.local.UserDataStoreManager(context)
    }
}