package se.arbitur.geocodingexample;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;
import se.arbitur.geocoding.AddressGeocoder;
import se.arbitur.geocoding.Callback;
import se.arbitur.geocoding.Constants.AddressTypes;
import se.arbitur.geocoding.Constants.LocationTypes;
import se.arbitur.geocoding.CoordinateGeocoder;
import se.arbitur.geocoding.Geocoder;
import se.arbitur.geocoding.Models.Coordinate;
import se.arbitur.geocoding.PlaceIdGeocoder;
import se.arbitur.geocoding.Response;
import se.arbitur.geocoding.Result;



public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Geocoder.LOGGING_LEVEL = HttpLoggingInterceptor.Level.BASIC;

		addressSearch("Humlegården");
		coordinateSearch(new Coordinate(59.3, 20.0));
		placeIdSearch("EiZGcsO2c8OkdHJhYmFja2VuLCBTa8OkcmhvbG1lbiwgU3ZlcmlnZQ");
	}





	private void addressSearch(String query) {
		new AddressGeocoder(query, getString(R.string.geocoding_key))
				.setLanguage("sv")
				.addComponent(AddressTypes.ADMINISTRATIVE_AREA_LEVEL_1, "Stockholm")
				.fetch(geoCallback);
	}



	private void coordinateSearch(Coordinate coordinate) {
		new CoordinateGeocoder(coordinate, getString(R.string.geocoding_key))
				.setLocationTypes(LocationTypes.ROOFTOP)
				.setResultTypes(AddressTypes.STREET_ADDRESS)
				.isSensor(true)
				.fetch(geoCallback);
	}


	private void placeIdSearch(String placeId) {
		new PlaceIdGeocoder(placeId, getString(R.string.geocoding_key))
				.setLanguage("sv")
				.fetch(geoCallback);
	}



	Callback geoCallback = new Callback() {
		@Override
		public void onSuccess(Response response) {
			Log.d(TAG, "Status code: " + response.getStatus());
			Log.d(TAG, "Responses: " + response.getResults().length);

			for (Result result : response.getResults()) {
				Log.d(TAG, "   Formatted address: " + result.getFormattedAddress());
				Log.d(TAG, "   Place ID: " + result.getPlaceId());
				Log.d(TAG, "   Location: " + result.getGeometry().getLocation());
				Log.d(TAG, "       Location type: " + result.getGeometry().getLocationType());
				Log.d(TAG, "       SouthWest: " + result.getGeometry().getViewport().getSouthWest());
				Log.d(TAG, "       NorthEast: " + result.getGeometry().getViewport().getNorthEast());
				Log.d(TAG, "   Types:");
				for (int i = 0; i < result.getAddressTypes().length; i++)
					Log.d(TAG, "       " + result.getAddressTypes()[i]);
			}
		}

		@Override
		public void onFailure(@Nullable Response response, @Nullable IOException exception) {
			if (response != null) Log.e(TAG, (response.getErrorMessage() == null) ? response.getStatus() : response.getErrorMessage());
			else Log.e(TAG, exception.getLocalizedMessage());
		}
	};
}
