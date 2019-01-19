package guide.betterfuture.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import guide.betterfuture.core.domain.executor.PostExecutionThread
import guide.betterfuture.core.domain.executor.ThreadExecutor

@Component(modules = [IOModule::class])
interface CoreComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun ioModule(ioModule: IOModule): Builder
        fun build(): CoreComponent
    }

    fun getThreadExecutor(): ThreadExecutor
    fun getPostExecutionThread(): PostExecutionThread
}
