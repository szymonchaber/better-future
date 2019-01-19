package guide.betterfuture.articlelist

import guide.betterfuture.articlelist.data.repository.ArticleDataRepository
import guide.betterfuture.articlelist.domain.Article
import guide.betterfuture.core.domain.executor.PostExecutionThread
import guide.betterfuture.core.domain.executor.ThreadExecutor
import guide.betterfuture.core.domain.interactor.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
        private val articlesRepository: ArticleDataRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
) : UseCase<List<Article>, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit): Observable<List<Article>> {
        return articlesRepository.articles()
    }
}
