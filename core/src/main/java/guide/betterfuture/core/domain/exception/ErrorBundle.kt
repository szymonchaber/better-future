package guide.betterfuture.core.domain.exception

interface ErrorBundle {

    val exception: Exception
    val errorMessage: String
}
