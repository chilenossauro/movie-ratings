package br.com.fernandopool.movieratings.shared

import io.reactivex.disposables.CompositeDisposable

abstract class ReactivePresenter<V> {

    private val disposable = CompositeDisposable()

    private var view: V? = null

    val isBinded: Boolean
        get() = view != null

    open fun bind(view: V) {
        this.view = view
    }

    fun unbind() {
        disposable.clear()
        this.view = null
    }

    fun subscription(): CompositeDisposable {
        return disposable
    }

    protected fun view(): V? {
        return view
    }
}