package br.com.fernandopool.movieratings.shared

import io.reactivex.Observable

abstract class ReactivePresenterIntent<PS : PartialState, VS : StateViewModel<PS, VS>, V : ReactiveViewIntent<VS>> : ReactivePresenter<V>() {

    protected fun subscribeActions(vararg actions: Observable<PS>?) {
        view()?.apply {
            val observable = merge(actions.toList(), initialState)
            subscription().clear()
            observable.bind(render())?.let { subscription().add(it) }
        }
    }

    private fun merge(actions: List<Observable<PS>?>, initialState: VS): Observable<VS> {
        return Observable.merge(actions)
                .scan(initialState) { state, partialState -> state.reducer(partialState) }
                .skip(1)
                .distinctUntilChanged()
    }
}