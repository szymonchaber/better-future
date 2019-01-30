package guide.betterfuture.articlelist.presentation.adapter

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import guide.betterfuture.articlelist.presentation.model.ArticleModel
import java.text.SimpleDateFormat
import java.util.*

class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val articleImage: AppCompatImageView = view.findViewById(guide.betterfuture.articlelist.R.id.articleImage)
    private val title: TextView = view.findViewById(guide.betterfuture.articlelist.R.id.title)
    private val author: TextView = view.findViewById(guide.betterfuture.articlelist.R.id.author)
    private val date: TextView = view.findViewById(guide.betterfuture.articlelist.R.id.date)


    fun bind(articleModel: ArticleModel) {
        Glide.with(articleImage).load(articleModel.image).into(articleImage)
        title.text = articleModel.title
        author.text = articleModel.author
        date.text = articleModel.createdAt
        val inputDateFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
        val viewingDateFormat = SimpleDateFormat(outputPattern, Locale.getDefault())
        val articleDate = inputDateFormat.parse(articleModel.createdAt)
        date.text = viewingDateFormat.format(articleDate)
    }

    companion object {

        private const val inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        private const val outputPattern = "dd MMM yyy"
    }
}
