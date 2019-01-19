package guide.betterfuture.articlelist.data.entity.mapper

import guide.betterfuture.articlelist.data.entity.NetworkArticle
import guide.betterfuture.articlelist.domain.Article

class ArticleEntityDataMapper {

    fun map(networkArticle: NetworkArticle): Article {
        return Article(networkArticle.title)
    }
}
