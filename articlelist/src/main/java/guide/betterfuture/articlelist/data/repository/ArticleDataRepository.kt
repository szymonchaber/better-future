package guide.betterfuture.articlelist.data.repository

import guide.betterfuture.articlelist.data.entity.mapper.ArticleEntityDataMapper
import guide.betterfuture.articlelist.data.repository.datasource.ArticleListDataStoreFactory
import guide.betterfuture.articlelist.domain.Article
import guide.betterfuture.articlelist.domain.repository.ArticleRepository
import io.reactivex.Observable
import javax.inject.Inject

class ArticleDataRepository @Inject internal constructor(
        private val articleListDataStoreFactory: ArticleListDataStoreFactory,
        private val articleEntityDataMapper: ArticleEntityDataMapper
) : ArticleRepository {

    override fun articles(): Observable<List<Article>> {

        //we always get all articles from the cloud
        val articleListDataStore = articleListDataStoreFactory.createCloudDataStore()
        return articleListDataStore.articleEntityList().map { list ->
            list.map(articleEntityDataMapper::map)
        }
    }

//    fun article(articleId: Int): Observable<NetworkArticle> {
//        val userDataStore = articleListDataStoreFactory.create(articleId)
//        return userDataStore.userEntityDetails(articleId).map(({ articleEntityDataMapper.transform() }))
//    }
}
