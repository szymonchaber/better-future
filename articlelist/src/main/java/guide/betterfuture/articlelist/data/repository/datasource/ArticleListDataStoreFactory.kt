package guide.betterfuture.articlelist.data.repository.datasource

import guide.betterfuture.articlelist.data.net.ArticleService

class ArticleListDataStoreFactory(private val articleService: ArticleService) {

    fun createCloudDataStore(): ArticleListDataStore {
        return CloudArticleListDataStore(articleService)
    }
}
