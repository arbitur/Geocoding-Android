package se.arbitur.geocoding


import android.os.Handler
import android.os.Looper
import okhttp3.Call
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import se.arbitur.geocoding.Constants.ResponseStatuses
import java.io.IOException
import se.arbitur.geocoding.Response as GeoResponse



abstract class Geocoder(val key: String?) {

	companion object {
		@JvmField var LOGGING_LEVEL = HttpLoggingInterceptor.Level.BODY

		@JvmStatic protected val defaultUrlBuilder: HttpUrl.Builder
			get() = HttpUrl.Builder()
							.scheme("https")
							.host("maps.googleapis.com")
							.addPathSegment("maps")
							.addPathSegment("api")
							.addPathSegment("geocode")
							.addPathSegment("json")
	}



	protected var language: String? = null

	private val LOOPER = Handler(Looper.getMainLooper())


	protected abstract val urlBuilder: HttpUrl.Builder


	fun fetch(callback: Callback) {
		val httpClient = OkHttpClient.Builder()
				.addInterceptor(HttpLoggingInterceptor().setLevel(LOGGING_LEVEL))
				.build()

		val url = urlBuilder

		if (key != null) url.addQueryParameter("key", key)
		if (language != null) url.addQueryParameter("language", language)

		val request = Request.Builder()
				.url(url.build())
				.build()

		httpClient.newCall(request).enqueue(object : okhttp3.Callback {
			override fun onResponse(call: Call?, response: Response?) {
				try {
					val json = response?.body()?.string() ?: throw NullPointerException()
					val resp = GeoResponse(JSONObject(json))

					if (resp.status == ResponseStatuses.OK)
						LOOPER.post { callback.onSuccess(resp) }
					else
						LOOPER.post { callback.onFailure(resp, null) }
				}
				catch (ex: Exception) {
					throw IOException(ex)
				}
			}

			override fun onFailure(call: Call?, e: IOException?) {
				LOOPER.post { callback.onFailure(null, e) }
			}
		})
	}
}
