package br.com.fernandopool.movieratings.infrastructure

import br.com.fernandopool.movieratings.domain.MovieGeneralInfo
import br.com.fernandopool.movieratings.domain.Rating

class SearchMapper {

    fun map(payload: MovieGeneralInfoPayload?): MovieGeneralInfo? =
            payload?.run {
                MovieGeneralInfo(
                        actors = actors,
                        awards = awards,
                        boxOffice = boxOffice,
                        country = country,
                        director = director,
                        dvd = dvd,
                        genre = genre,
                        imdbID = imdbID,
                        imdbRating = imdbRating,
                        imdbVotes = imdbVotes,
                        language = language,
                        metascore = metascore,
                        plot = plot,
                        poster = poster,
                        production = production,
                        rated = rated,
                        ratings = mapRatings(ratings),
                        released = released,
                        response = response,
                        runtime = runtime,
                        title = title,
                        type = type,
                        website = website,
                        writer = writer,
                        year = year
                )
            }

    fun mapRatings(payload: List<RatingPayload>?): List<Rating>? =
            payload?.run {
                this.map {
                    Rating(
                            source = it.source,
                            value = it.value
                    )
                }
            }

}