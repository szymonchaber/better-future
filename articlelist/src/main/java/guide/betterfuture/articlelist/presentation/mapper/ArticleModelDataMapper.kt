package guide.betterfuture.articlelist.presentation.mapper

import guide.betterfuture.articlelist.domain.Article
import guide.betterfuture.articlelist.presentation.model.ArticleModel
import javax.inject.Inject

class ArticleModelDataMapper @Inject constructor() {

    fun transform(article: Article): ArticleModel {
        return ArticleModel(article.title)
    }

    fun transform(articlesCollection: Collection<Article>): Collection<ArticleModel> {
        return articlesCollection.map {
            transform(it)
        }
    }
}
