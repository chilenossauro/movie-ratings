package br.com.fernandopool.movieratings.dagger.components

import br.com.fernandopool.movieratings.DAO
import br.com.fernandopool.movieratings.MRApplication
import br.com.fernandopool.movieratings.dagger.modules.ActivityBuilderModule
import br.com.fernandopool.movieratings.dagger.modules.AppModule
import br.com.fernandopool.movieratings.dagger.modules.CallAdapterFactoryModule
import br.com.fernandopool.movieratings.dagger.modules.DAOModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    CallAdapterFactoryModule::class,
    DAOModule::class
])
interface CoreComponent : AndroidInjector<MRApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MRApplication>

    fun application(): MRApplication

    fun dao(): DAO

}

