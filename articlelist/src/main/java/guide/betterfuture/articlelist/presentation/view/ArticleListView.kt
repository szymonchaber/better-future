package guide.betterfuture.articlelist.presentation.view

import guide.betterfuture.articlelist.presentation.model.ArticleModel
import guide.betterfuture.core.presentation.view.DataView

interface ArticleListView : DataView {

    fun renderArticleList(articleListModel: Collection<ArticleModel>)
    fun viewArticle(article: ArticleModel)
}
