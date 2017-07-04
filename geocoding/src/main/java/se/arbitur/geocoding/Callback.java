package se.arbitur.geocoding;


import java.io.IOException;



public interface Callback {
	/**
	 * response is not null and {@link Response#status status} is equal to {@link se.arbitur.geocoding.Constants.ResponseStatuses#OK OK}
	 * @param response The response
	 */
	void onResponse(Response response);

	/**
	 * If {@link Response#status status} is anything but {@link se.arbitur.geocoding.Constants.ResponseStatuses#OK OK} then response wont be null.
	 * If an exception was thrown by OkHttp then exception wont be null.
	 * @param response @Nullable The response
	 * @param exception @Nullable The exception
	 */
	void onFailed(Response response, IOException exception);
}
