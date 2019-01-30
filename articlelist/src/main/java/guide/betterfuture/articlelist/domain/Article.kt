package guide.betterfuture.articlelist.domain

import java.io.Serializable

data class Article(
    val id: String,
    val title: String,
    val body: String,
    val image: String?,
    val author: String,
    val createdAt: String
) : Serializable
