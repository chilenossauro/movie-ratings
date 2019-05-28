package br.com.fernandopool.movieratings

import android.app.Activity
import android.support.multidex.MultiDexApplication
import br.com.fernandopool.movieratings.dagger.components.CoreComponent
import br.com.fernandopool.movieratings.dagger.components.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MRApplication : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    private lateinit var coreComponent: CoreComponent

    fun core(): CoreComponent = coreComponent

    override fun onCreate() {
        super.onCreate()

        initComponents(this)
    }

    fun initComponents(app: MRApplication) {
        coreComponent = DaggerCoreComponent.factory().create(app) as CoreComponent
        coreComponent.inject(app)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}