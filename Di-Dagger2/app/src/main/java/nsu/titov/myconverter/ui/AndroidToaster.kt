package nsu.titov.myconverter.ui

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import nsu.titov.myconverter.presentation.Toaster
import javax.inject.Inject

//TODO DI
class AndroidToaster @Inject constructor(
	private val context: Context,
) : Toaster {

	override fun showToast(message: String?) {
		val handler = Handler(Looper.getMainLooper())

		handler.post {
			Toast.makeText(
				context,
				message ?: "Aboba",
				Toast.LENGTH_SHORT,
			).show()
		}
	}
}