package br.com.fernandopool.movieratings.infrastructure

import br.com.fernandopool.movieratings.DAO
import br.com.fernandopool.movieratings.domain.MovieGeneralInfo
import br.com.fernandopool.movieratings.domain.SearchSource
import io.reactivex.Flowable
import io.reactivex.Scheduler

class SearchInfrastructure(val dao: DAO,val scheduler: Scheduler,val mapper: SearchMapper): SearchSource {

    override fun fetchMovieByImdbId(imdbId: String?): Flowable<MovieGeneralInfo> =
            dao.getMovieInfoByImdbId(imdbId)
                    .subscribeOn(scheduler)
                    .map { mapper.map(it) }

    override fun fetchMovieByMovieTitle(movieTitle: String?): Flowable<MovieGeneralInfo> =
            dao.getMovieInfoByMovieTitle(movieTitle)
                    .subscribeOn(scheduler)
                    .map { mapper.map(it) }

    override fun fetchMovieByQuery(query: String?): Flowable<MovieGeneralInfo> =
            dao.getMovieInfoBySearch(query)
                    .subscribeOn(scheduler)
                    .map { mapper.map(it) }
}