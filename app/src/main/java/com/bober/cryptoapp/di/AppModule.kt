package com.bober.cryptoapp.di

import com.bober.cryptoapp.common.Constants
import com.bober.cryptoapp.data.remote.CoinPaprikaApi
import com.bober.cryptoapp.data.repository.CoinRepositoryImpl
import com.bober.cryptoapp.data.repository.FakeCoinRepository
import com.bober.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    // Provides the Retrofit API instance to the rest of the app
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            // GsonConverter handles JSON parsing (using those @SerializedName annotations)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    // Provides the Repository. We return the interface (CoinRepository)
    // but the actual implementation is CoinRepositoryImpl
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        //return CoinRepositoryImpl(api)
        return FakeCoinRepository()
    }
}