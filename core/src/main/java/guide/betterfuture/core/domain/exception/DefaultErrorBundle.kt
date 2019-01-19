package guide.betterfuture.core.domain.exception

class DefaultErrorBundle(override val exception: Exception) : ErrorBundle {

    override val errorMessage: String
        get() = exception.message ?: "Unknown error"
}
