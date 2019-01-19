package guide.betterfuture.core.presentation.view.tools

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.widget.Toast

fun Fragment.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireActivity(), message, length).show()
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireActivity(), message, length).show()
}
