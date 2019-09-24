package br.com.fernandopool.movieratings.shared

interface StateViewModel<in PS, out VS> {
    fun reducer(partialState: PS): VS
}