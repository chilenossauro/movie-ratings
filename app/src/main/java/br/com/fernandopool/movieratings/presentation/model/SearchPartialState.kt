package br.com.fernandopool.movieratings.presentation.model

import br.com.fernandopool.movieratings.presentation.MovieGeneralInfoViewModel
import br.com.fernandopool.movieratings.shared.PartialState

sealed class SearchPartialState: PartialState {

    class SearchLoading: SearchPartialState()
    class SearchLoaded(val movieGeneralInfo: MovieGeneralInfoViewModel?): SearchPartialState()

}