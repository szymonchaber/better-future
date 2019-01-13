package guide.betterfuture.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [IOModule::class])
interface CoreComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun ioModule(ioModule: IOModule): Builder
        fun build(): CoreComponent
    }
}
