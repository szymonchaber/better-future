package guide.betterfuture.articlelist.presentation.presenter

import guide.betterfuture.articlelist.GetArticlesUseCase
import guide.betterfuture.articlelist.domain.Article
import guide.betterfuture.articlelist.presentation.mapper.ArticleModelDataMapper
import guide.betterfuture.articlelist.presentation.model.ArticleModel
import guide.betterfuture.articlelist.presentation.view.ArticleListView
import guide.betterfuture.core.domain.exception.DefaultErrorBundle
import guide.betterfuture.core.domain.exception.ErrorBundle
import guide.betterfuture.core.presentation.exception.ErrorMessageFactory
import guide.betterfuture.core.presentation.presenter.Presenter
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ArticleListPresenter @Inject constructor(
        private val articleModelMapper: ArticleModelDataMapper,
        private val getArticlesUseCase: GetArticlesUseCase
) : Presenter {

    private var articleListView: ArticleListView? = null

    fun setView(view: ArticleListView) {
        articleListView = view
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
        getArticlesUseCase.dispose()
        articleListView = null
    }

    fun initialize() {
        hideViewRetry()
        showViewLoading()
        getArticles()
    }

    fun onArticleClicked(article: ArticleModel) {
        articleListView?.viewArticle(article)
    }

    private fun getArticles() {
        getArticlesUseCase.execute(ArticleListObserver(), Unit)
    }

    private fun showViewLoading() {
        articleListView?.showLoading()
    }

    private fun hideViewLoading() {
        articleListView?.hideLoading()
    }

    private fun showViewRetry() {
        articleListView?.showRetry()
    }

    private fun hideViewRetry() {
        articleListView?.hideRetry()
    }

    private fun showErrorMessage(errorBundle: ErrorBundle) {
        val errorMessage = ErrorMessageFactory.create(
                articleListView?.context()!!,
                errorBundle.exception
        )
        articleListView?.showError(errorMessage)
    }

    private fun showArticleListInView(networkArticleList: List<Article>) {
        val articleList = articleModelMapper.transform(networkArticleList)
        articleListView?.renderArticleList(articleList)
    }

    private inner class ArticleListObserver : DisposableObserver<List<Article>>() {

        override fun onComplete() {
            this@ArticleListPresenter.hideViewLoading()
        }

        override fun onError(throwable: Throwable) {
            this@ArticleListPresenter.hideViewLoading()
            this@ArticleListPresenter.showErrorMessage(DefaultErrorBundle(throwable as Exception))
            this@ArticleListPresenter.showViewRetry()
        }

        override fun onNext(articleList: List<Article>) {
            this@ArticleListPresenter.showArticleListInView(articleList)
        }
    }
}
