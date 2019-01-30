package guide.betterfuture.articlelist.data.repository.datasource

import guide.betterfuture.articlelist.data.entity.NetworkArticle
import guide.betterfuture.articlelist.data.net.ArticleService
import io.reactivex.Observable

interface ArticleListDataStore {

    fun articleEntityList(): Observable<List<NetworkArticle>>
}

class CloudArticleListDataStore(private val articleService: ArticleService) : ArticleListDataStore {

    override fun articleEntityList(): Observable<List<NetworkArticle>> {
        return articleService.getArticles()
    }
}
