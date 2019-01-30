package guide.betterfuture.articlelist.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NetworkArticle(
    @SerializedName("_id")
    val id: String,
    val title: String,
    val body: String,
    val image: String?,
    val author: String,
    val createdAt: String
) : Serializable
