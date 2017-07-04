package se.arbitur.geocoding;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import se.arbitur.geocoding.Constants.ResponseStatuses;



public abstract class Geocoder {
	public static HttpLoggingInterceptor.Level loggingLevel = HttpLoggingInterceptor.Level.BODY;

	protected static HttpUrl.Builder getDefaultUrlBuilder() {
		return new HttpUrl.Builder()
				.scheme("https")
				.host("maps.googleapis.com")
				.addPathSegment("maps")
				.addPathSegment("api")
				.addPathSegment("geocode")
				.addPathSegment("json");
	}

	protected String key;
	protected String language;



	protected Geocoder(String key) {
		this.key = key;
	}



	protected abstract HttpUrl.Builder getUrlBuilder();



	public void fetch(final Callback callback) {
		OkHttpClient httpClient = new OkHttpClient.Builder()
				.addInterceptor(new HttpLoggingInterceptor().setLevel(loggingLevel))
				.build();


		HttpUrl.Builder url = getUrlBuilder();

		if (language != null) 	url.addQueryParameter("language", language);
		if (key != null) 		url.addQueryParameter("key", key);

		Request request = new Request.Builder()
				.url(url.build())
				.build();

		httpClient.newCall(request).enqueue(new okhttp3.Callback() {
			Handler handler = new Handler(Looper.getMainLooper());

			@Override
			public void onFailure(Call call, final IOException e) {
				handler.post(new Runnable() {
					@Override
					public void run() {
						callback.onFailed(null, e);
					}
				});
			}

			@Override
			public void onResponse(Call call, okhttp3.Response response) throws IOException {
				String rawBody = response.body().string();
				final Response geoResponse = new Gson().fromJson(rawBody, Response.class);

				if (geoResponse.getStatus().equals(ResponseStatuses.OK)) {
					handler.post(new Runnable() {
						@Override
						public void run() {
							callback.onResponse(geoResponse);
						}
					});
				}
				else {
					handler.post(new Runnable() {
						@Override
						public void run() {
							callback.onFailed(geoResponse, null);
						}
					});
				}
			}
		});
	}
}
