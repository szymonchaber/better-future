package guide.betterfuture.articlelist.di

import dagger.Component
import guide.betterfuture.articlelist.presentation.view.ArticleListFragment
import guide.betterfuture.core.di.CoreComponent

@Component(dependencies = [CoreComponent::class], modules = [ArticleListModule::class])
interface ArticleListComponent {

    fun inject(articleListFragment: ArticleListFragment)
}
