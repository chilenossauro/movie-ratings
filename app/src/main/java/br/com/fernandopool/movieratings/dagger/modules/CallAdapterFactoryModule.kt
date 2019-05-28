package br.com.fernandopool.movieratings.dagger.modules

import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class CallAdapterFactoryModule {

    @Provides
    @Singleton
    fun rxJavaCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

}