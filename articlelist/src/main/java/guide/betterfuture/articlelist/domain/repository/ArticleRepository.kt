package guide.betterfuture.articlelist.domain.repository

import guide.betterfuture.articlelist.domain.Article
import io.reactivex.Observable

interface ArticleRepository {

    fun articles(): Observable<List<Article>>
}
