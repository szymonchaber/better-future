package guide.betterfuture.articlelist.di

import dagger.Component
import guide.betterfuture.articlelist.ArticleListFragment
import guide.betterfuture.core.di.CoreComponent

@Component(dependencies = [CoreComponent::class])
interface ArticleListComponent {

    fun inject(articleListFragment: ArticleListFragment)
}
