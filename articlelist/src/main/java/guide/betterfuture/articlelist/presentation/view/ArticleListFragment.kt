package guide.betterfuture.articlelist.presentation.view

import ArticleListComponentHolder
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guide.betterfuture.articlelist.R
import guide.betterfuture.articlelist.presentation.adapter.ArticleAdapter
import guide.betterfuture.articlelist.presentation.model.ArticleModel
import guide.betterfuture.articlelist.presentation.presenter.ArticleListPresenter
import guide.betterfuture.core.presentation.view.tools.toast
import kotlinx.android.synthetic.main.article_list_fragment.*
import javax.inject.Inject

class ArticleListFragment : Fragment(), ArticleListView {

    @Inject
    internal lateinit var presenter: ArticleListPresenter
    private lateinit var adapter: ArticleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.article_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArticleListComponentHolder.articleListComponent.inject(this)
        presenter.setView(this)
        initAdapter()
        if (savedInstanceState == null) {
            loadArticles()
        }
    }

    private fun initAdapter() {
        swipeRefreshLayout.setOnRefreshListener {
            loadArticles()
        }
        adapter = ArticleAdapter(requireContext())
        adapter.onItemClickListener = {
            presenter.onArticleClicked(it)
        }
        articleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        articleRecyclerView.adapter = adapter
    }

    private fun loadArticles() {
        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        presenter.pause()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun renderArticleList(articleListModel: Collection<ArticleModel>) {
        adapter.setArticles(articleListModel.toList())
    }

    override fun viewArticle(article: ArticleModel) {
        toast(R.string.toast_not_yet_implemented)
    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showRetry() {
        //TODO
    }

    override fun hideRetry() {
        //TODO
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun context(): Context {
        return requireContext()
    }
}
