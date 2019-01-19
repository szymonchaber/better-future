package guide.betterfuture.core.presentation.view

import android.content.Context

interface DataView {

    fun showLoading()

    fun hideLoading()

    fun showRetry()

    fun hideRetry()

    fun showError(message: String)

    fun context(): Context
}
