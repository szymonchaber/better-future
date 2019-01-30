package guide.betterfuture.articlelist.data.net

import guide.betterfuture.articlelist.data.entity.NetworkArticle
import io.reactivex.Observable
import retrofit2.http.GET

interface ArticleService {

    @GET("articles")
    fun getArticles(): Observable<List<NetworkArticle>>
}
