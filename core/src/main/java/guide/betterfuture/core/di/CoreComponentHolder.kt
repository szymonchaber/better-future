package guide.betterfuture.core.di

import android.app.Application

object CoreComponentHolder {

    private lateinit var coreComponent: CoreComponent

    @JvmStatic
    fun init(application: Application) {
        coreComponent = DaggerCoreComponent.builder()
            .applicationContext(application)
            .build()
    }

    fun get() = coreComponent
}
