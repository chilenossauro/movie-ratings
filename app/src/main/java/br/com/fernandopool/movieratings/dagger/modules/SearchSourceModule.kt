package br.com.fernandopool.movieratings.dagger.modules

import br.com.fernandopool.movieratings.DAO
import br.com.fernandopool.movieratings.dagger.scopes.ScreenScope
import br.com.fernandopool.movieratings.domain.SearchSource
import br.com.fernandopool.movieratings.infrastructure.SearchInfrastructure
import br.com.fernandopool.movieratings.infrastructure.SearchMapper
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import javax.inject.Scope

@Module
class SearchSourceModule {

    @Provides
    @ScreenScope
    fun create(dao: DAO): SearchSource = SearchInfrastructure(dao, Schedulers.io(), SearchMapper())


}