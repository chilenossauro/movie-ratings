package br.com.fernandopool.movieratings.dagger.modules

import android.app.Application
import br.com.fernandopool.movieratings.MRApplication
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun application(app: MRApplication): Application
}