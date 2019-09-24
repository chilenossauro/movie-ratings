package br.com.fernandopool.movieratings.presentation

import br.com.fernandopool.movieratings.domain.SearchSource
import br.com.fernandopool.movieratings.presentation.model.SearchPartialState
import br.com.fernandopool.movieratings.shared.ReactivePresenterIntent
import io.reactivex.Observable

class SearchPresenter(val source: SearchSource, val mapper: MovieGeneralInfoViewModelMapper): ReactivePresenterIntent<SearchPartialState, SearchState, SearchView>() {

    override fun bind(view: SearchView) {
        super.bind(view)

        val loadMovieInfoAction: Observable<SearchPartialState>? = loadSearchPipeline()
    }

    private fun loadSearchPipeline(): Observable<SearchPartialState>? {
        return view()
                ?.fetchMovieIntent()
                ?.flatMap {
                    fetchMovie()
                            .map<SearchPartialState>(SearchPartialState::SearchLoaded)
                            .startWith(SearchPartialState.SearchLoading())
                }
    }

    private fun fetchMovie() = source
            .fetchMovieByMovieTitle("Matrix")
            .map(mapper::map)
}