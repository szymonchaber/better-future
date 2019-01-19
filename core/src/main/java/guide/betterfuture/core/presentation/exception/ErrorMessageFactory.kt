package guide.betterfuture.core.presentation.exception

import android.content.Context
import guide.betterfuture.core.R
import guide.betterfuture.core.data.exception.NetworkConnectionException

object ErrorMessageFactory {

    /**
     * Creates a String representing an error message.
     *
     * @param context Context needed to retrieve string resources.
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return [String] an error message.
     */
    fun create(context: Context, exception: Exception): String {
        var message = context.getString(R.string.error_general)

        if (exception is NetworkConnectionException) {
            message = context.getString(R.string.error_no_connection)
        }

        return message
    }
}
