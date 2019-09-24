package br.com.fernandopool.movieratings.presentation

import br.com.fernandopool.movieratings.domain.MovieGeneralInfo

class MovieGeneralInfoViewModelMapper {


    fun map(movieInfo: MovieGeneralInfo?): MovieGeneralInfoViewModel =
            MovieGeneralInfoViewModel(movieInfo?.title, movieInfo?.year)
}