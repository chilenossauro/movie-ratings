package br.com.fernandopool.movieratings.domain

import io.reactivex.Observable

interface SearchSource {

    fun fetchMovieByImdbId(imdbId: String?): Observable<MovieGeneralInfo>

    fun fetchMovieByMovieTitle(movieTitle: String?): Observable<MovieGeneralInfo>

    fun fetchMovieByQuery(query: String?): Observable<MovieGeneralInfo>
}