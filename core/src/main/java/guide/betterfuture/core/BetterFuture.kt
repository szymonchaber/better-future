package guide.betterfuture.core

import android.app.Application
import guide.betterfuture.core.di.CoreComponentHolder

class BetterFuture : Application() {

    override fun onCreate() {
        super.onCreate()
        CoreComponentHolder.init(this)
    }
}
