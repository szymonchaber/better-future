package guide.betterfuture.articlelist.data.repository.datasource

import guide.betterfuture.articlelist.data.entity.NetworkArticle
import io.reactivex.Observable

interface ArticleListDataStore {

    fun articleEntityList(): Observable<List<NetworkArticle>>
}

class CloudArticleListDataStore : ArticleListDataStore {

    override fun articleEntityList(): Observable<List<NetworkArticle>> {
        return Observable.just(listOf(
                NetworkArticle("Generic title1"),
                NetworkArticle("Generic title2"),
                NetworkArticle("Generic title3"),
                NetworkArticle("Generic title4"),
                NetworkArticle("Generic title5"),
                NetworkArticle("Generic title6"),
                NetworkArticle("Generic title7")

        ))
    }
}
