package br.com.fernandopool.movieratings.shared

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import java.lang.Exception

fun <T> Observable<T>.bind(uiFunc: Function<Observable<T>, Disposable>?): Disposable? {
    return try {
        uiFunc?.apply(this)
    } catch (e: Exception) {
//        LogUtil.e(e, e.message)
        null
    }
}