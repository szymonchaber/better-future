package guide.betterfuture.articlelist.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import guide.betterfuture.articlelist.R
import guide.betterfuture.articlelist.presentation.model.ArticleModel

class ArticleAdapter constructor(context: Context) : RecyclerView.Adapter<ArticleViewHolder>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private var articles: List<ArticleModel> = listOf()

    var onItemClickListener: ((ArticleModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(layoutInflater.inflate(R.layout.article_list_item, parent, false))
    }

    fun setArticles(articleList: List<ArticleModel>) {
        articles = articleList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(article)
        }
    }
}

