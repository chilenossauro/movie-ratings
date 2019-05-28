package br.com.fernandopool.movieratings.dagger.modules

import br.com.fernandopool.movieratings.DAO
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [CallAdapterFactoryModule::class])
class DAOModule {

    @Singleton
    @Provides
    fun create(factoryRxJava: CallAdapter.Factory): DAO {

        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/?apikey=132529bd")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(factoryRxJava)
                .build()

        return retrofit.create(DAO::class.java)
    }
}