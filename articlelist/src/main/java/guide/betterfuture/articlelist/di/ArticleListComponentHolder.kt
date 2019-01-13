import guide.betterfuture.articlelist.di.ArticleListComponent
import guide.betterfuture.articlelist.di.DaggerArticleListComponent
import guide.betterfuture.core.di.CoreComponentHolder

object ArticleListComponentHolder {

    val articleListComponent: ArticleListComponent by lazy {
        DaggerArticleListComponent
            .builder()
            .coreComponent(CoreComponentHolder.get())
            .build()
    }
}
