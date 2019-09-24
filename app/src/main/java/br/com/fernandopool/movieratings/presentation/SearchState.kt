package br.com.fernandopool.movieratings.presentation

import br.com.fernandopool.movieratings.presentation.model.SearchPartialState
import br.com.fernandopool.movieratings.shared.StateViewModel

data class SearchState(val data: MovieGeneralInfoViewModel? = null, val loading: Boolean = false): StateViewModel<SearchPartialState, SearchState> {

    override fun reducer(partialState: SearchPartialState): SearchState {

        return when (partialState) {

            is SearchPartialState.SearchLoading -> this.copy(
                    loading = true
            )

            is SearchPartialState.SearchLoaded -> this.copy(
                    loading = false,
                    data = partialState.movieGeneralInfo
            )

        }

    }
}