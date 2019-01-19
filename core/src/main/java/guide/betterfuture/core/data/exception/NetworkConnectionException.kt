package guide.betterfuture.core.data.exception

class NetworkConnectionException : Exception {

    constructor() : super()

    constructor(cause: Throwable) : super(cause)
}
