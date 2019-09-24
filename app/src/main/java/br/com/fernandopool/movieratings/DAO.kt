package br.com.fernandopool.movieratings

import br.com.fernandopool.movieratings.infrastructure.MovieGeneralInfoPayload
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface DAO {

    @GET
    fun getMovieInfoByMovieTitle(
            @Query("t") movieTitle: String?
    ): Flowable<MovieGeneralInfoPayload>

    @GET
    fun getMovieInfoByImdbId(
            @Query("i") imdbId: String?
    ): Flowable<MovieGeneralInfoPayload>

    @GET
    fun getMovieInfoBySearch(
            @Query("s") query: String?
    ): Flowable<MovieGeneralInfoPayload>
}