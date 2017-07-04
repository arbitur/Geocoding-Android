package se.arbitur.geocoding;


import android.text.TextUtils;

import okhttp3.HttpUrl;
import se.arbitur.geocoding.Models.Coordinate;



public final class ReverseGeocoding extends Geocoder {
	String placeId;
	Coordinate coordinate;

	String[] resultTypes;
	String[] locationTypes;
	Boolean isSensor;



	public ReverseGeocoding(Coordinate coordinate, String key) {
		super(key);
		this.coordinate = coordinate;
	}

	public ReverseGeocoding(double latitude, double longitude, String key) {
		this(new Coordinate(latitude, longitude), key);
	}

	public ReverseGeocoding(String placeId, String key) {
		super(key);
		this.placeId = placeId;
	}



	@Override
	protected HttpUrl.Builder getUrlBuilder() {
		HttpUrl.Builder builder = getDefaultUrlBuilder();

		if (coordinate != null) {
			builder.addQueryParameter("latlng", coordinate.toString());
			if (resultTypes != null) 	builder.addQueryParameter("result_type", TextUtils.join("|", resultTypes).toLowerCase());
			if (locationTypes != null) 	builder.addQueryParameter("location_type=", TextUtils.join("|", locationTypes).toLowerCase());
			if (isSensor != null) 		builder.addQueryParameter("sensor", isSensor.toString());
		}
		else
			builder.addQueryParameter("place_id", placeId);

		return builder;
	}



	/**
	 * Set language for values.
	 * @see <a href="https://developers.google.com/maps/faq#languagesupport">List of supported languages</a>
	 * @param language Language code ex: "en", "sv"
	 */
	public ReverseGeocoding setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Set result types.
	 * Available types found in {@link se.arbitur.geocoding.Constants.AddressComponents AddressComponents}
	 * @param types The types
	 */
	public ReverseGeocoding setResultTypes(String... types) {
		this.resultTypes = types;
		return this;
	}

	/**
	 * Set location types.
	 * Available types found in {@link se.arbitur.geocoding.Constants.LocationTypes LocationTypes}
	 * @param types The types
	 */
	public ReverseGeocoding setLocationTypes(String... types) {
		this.locationTypes = types;
		return this;
	}

	/**
	 * Set isSensor
	 * @param isSensor If sensor
	 */
	public ReverseGeocoding isSensor(boolean isSensor) {
		this.isSensor = isSensor;
		return this;
	}
}
