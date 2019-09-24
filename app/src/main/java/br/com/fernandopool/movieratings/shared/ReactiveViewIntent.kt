package br.com.fernandopool.movieratings.shared

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function

interface ReactiveViewIntent<VS> {

    val initialState: VS

    fun render(): Function<Observable<VS>, Disposable>
}