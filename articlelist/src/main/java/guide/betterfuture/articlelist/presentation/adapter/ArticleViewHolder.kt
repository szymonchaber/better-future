package guide.betterfuture.articlelist.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import guide.betterfuture.articlelist.R
import guide.betterfuture.articlelist.presentation.model.ArticleModel

class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title: TextView = view.findViewById(R.id.title)

    fun bind(articleModel: ArticleModel) {
        title.text = articleModel.title
    }
}
