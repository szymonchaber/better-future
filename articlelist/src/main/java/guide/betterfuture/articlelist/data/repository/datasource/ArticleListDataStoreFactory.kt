package guide.betterfuture.articlelist.data.repository.datasource

class ArticleListDataStoreFactory {

    fun createCloudDataStore(): ArticleListDataStore {
        return CloudArticleListDataStore()
    }
}
