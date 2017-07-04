package se.arbitur.geocodingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;
import se.arbitur.geocoding.Geocoding;
import se.arbitur.geocoding.Callback;
import se.arbitur.geocoding.Geocoder;
import se.arbitur.geocoding.Constants.AddressTypes;
import se.arbitur.geocoding.Constants.LocationTypes;
import se.arbitur.geocoding.Models.Coordinate;
import se.arbitur.geocoding.ReverseGeocoding;
import se.arbitur.geocoding.Response;
import se.arbitur.geocoding.Result;



public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Geocoder.loggingLevel = HttpLoggingInterceptor.Level.BASIC;

		addressSearch("Humlegården");
		coordinateSearch(new Coordinate(59.3, 20.0));
		placeIdSearch("EiZGcsO2c8OkdHJhYmFja2VuLCBTa8OkcmhvbG1lbiwgU3ZlcmlnZQ");
	}





	private void addressSearch(String query) {
		new Geocoding(query, getString(R.string.geocoding_key))
				.setLanguage("sv")
				.addComponent(AddressTypes.ADMINISTRATIVE_AREA_LEVEL_1, "Stockholm")
				.fetch(new Callback() {
					@Override
					public void onResponse(Response response) {
						for (Result result : response.getResults())
							Log.d(TAG, "Address: " + result.getFormattedAddress());
					}

					@Override
					public void onFailed(Response response, IOException exception) {
						if (response != null) Log.e(TAG, response.getErrorMessage() == null ? response.getStatus() : response.getErrorMessage());
						else Log.e(TAG, exception.getLocalizedMessage());
					}
				});
	}



	private void coordinateSearch(Coordinate coordinate) {
		new ReverseGeocoding(coordinate, getString(R.string.geocoding_key))
				.setLocationTypes(LocationTypes.ROOFTOP)
				.setResultTypes(AddressTypes.STREET_ADDRESS)
				.isSensor(true)
				.fetch(new Callback() {
					@Override
					public void onResponse(Response response) {
						for (Result result : response.getResults())
							Log.d(TAG, "Coordinate: " + result.getFormattedAddress());
					}

					@Override
					public void onFailed(Response response, IOException exception) {
						if (response != null) Log.e(TAG, response.getErrorMessage() == null ? response.getStatus() : response.getErrorMessage());
						else Log.e(TAG, exception.getLocalizedMessage());
					}
				});
	}


	private void placeIdSearch(String placeId) {
		new ReverseGeocoding(placeId, getString(R.string.geocoding_key))
				.setLanguage("sv")
				.fetch(new Callback() {
					@Override
					public void onResponse(Response response) {
						for (Result result : response.getResults())
							Log.d(TAG, "PlaceID: " + result.getFormattedAddress());
					}

					@Override
					public void onFailed(Response response, IOException exception) {
						if (response != null) Log.e(TAG, response.getErrorMessage() == null ? response.getStatus() : response.getErrorMessage());
						else Log.e(TAG, exception.getLocalizedMessage());
					}
				});
	}
}
