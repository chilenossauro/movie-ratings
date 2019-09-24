package br.com.fernandopool.movieratings

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var application: MRApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        AndroidInjection.inject(this)
    }

    fun networkTest() {

    }

}
