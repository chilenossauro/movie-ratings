package br.com.fernandopool.movieratings.presentation

import br.com.fernandopool.movieratings.shared.ReactiveViewIntent
import io.reactivex.Observable

interface SearchView: ReactiveViewIntent<SearchState> {

    fun fetchMovieIntent(): Observable<Unit>

}