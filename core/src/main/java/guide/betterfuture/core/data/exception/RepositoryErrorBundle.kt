package guide.betterfuture.core.data.exception

import guide.betterfuture.core.domain.exception.ErrorBundle

internal class RepositoryErrorBundle(override val exception: Exception) : ErrorBundle {

    override val errorMessage: String
        get() = exception.message.orEmpty()
}
