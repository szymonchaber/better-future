package guide.betterfuture.main.di

import dagger.Component
import guide.betterfuture.core.di.CoreComponent

@Component(dependencies = [CoreComponent::class])
interface MainComponent {
}
