package se.arbitur.geocoding


import java.io.IOException



interface Callback {
	/**
	 * [Response.status] is equal to [OK][se.arbitur.geocoding.Constants.ResponseStatuses.OK]
	 * @param response The response
	 */
	fun onSuccess(response: Response)

	/**
	 * If [Response.status] is anything but [OK][se.arbitur.geocoding.Constants.ResponseStatuses.OK] then response wont be null.
	 * If an exception was thrown by OkHttp then exception wont be null.
	 * @param response @Nullable The response
	 * @param exception @Nullable The exception
	 */
	fun onFailure(response: Response?, exception: IOException?)
}