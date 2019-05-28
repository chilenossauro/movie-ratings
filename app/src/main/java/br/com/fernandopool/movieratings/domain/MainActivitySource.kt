package br.com.fernandopool.movieratings.domain

import io.reactivex.Flowable

interface MainActivitySource {

    fun fetchMovieNameByImdbId(imdbId: String?): Flowable<MovieGeneralInfo>
}