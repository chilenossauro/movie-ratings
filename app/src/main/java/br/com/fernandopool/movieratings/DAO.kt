package br.com.fernandopool.movieratings

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface DAO {

    @GET
    fun getMovieName(
            @Query("i") movieId: String
    ): Flowable<String>
}