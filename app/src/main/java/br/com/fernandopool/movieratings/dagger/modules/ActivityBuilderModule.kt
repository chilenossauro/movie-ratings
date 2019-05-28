package br.com.fernandopool.movieratings.dagger.modules

import br.com.fernandopool.movieratings.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun searchActivity(): SearchActivity
}