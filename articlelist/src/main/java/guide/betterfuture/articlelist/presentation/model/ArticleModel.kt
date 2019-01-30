package guide.betterfuture.articlelist.presentation.model

import java.io.Serializable

data class ArticleModel(
    val id: String,
    val title: String,
    val body: String,
    val image: String?,
    val author: String,
    val createdAt: String
) : Serializable
