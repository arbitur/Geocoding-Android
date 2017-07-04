package se.arbitur.geocoding;


import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import se.arbitur.geocoding.Models.Bounds;



public final class Geocoding extends Geocoder {
	String query;
	Bounds bounds;
	String region;
	List<String> components = new ArrayList<>();



	public Geocoding(String query, String key) {
		super(key);
		this.query = query;
	}


	@Override
	protected HttpUrl.Builder getUrlBuilder() {
		HttpUrl.Builder builder = getDefaultUrlBuilder();

		builder.addQueryParameter("address", query);

		if (bounds != null) 	builder.addQueryParameter("bounds", bounds.toString());
		if (region != null) 	builder.addQueryParameter("region", region);
		if (!components.isEmpty()) builder.addQueryParameter("components", TextUtils.join("|", components));

		return builder;
	}



	/**
	 * Set language for values.
	 * @see <a href="https://developers.google.com/maps/faq#languagesupport">List of supported languages</a>
	 * @param language Language code ex: "en", "sv"
	 */
	public Geocoding setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Set prioritized bounds, searches within bounds first
	 * @param bounds The bounds, southWest -> northEast
	 * @return
	 */
	public Geocoding setBounds(Bounds bounds) {
		this.bounds = bounds;
		return this;
	}

	/**
	 * Set the region
	 * @param region a ccTLD (Country Code Top Level Domain) ex: uk, es, us
	 */
	public Geocoding setRegion(String region) {
		this.region = region;
		return this;
	}

	/**
	 * Add a component.
	 * Available types are {@link se.arbitur.geocoding.Constants.AddressTypes AddressTypes}.[ROUTE, LOCALITY, ADMINISTRATIVE_AREA, POSTAL_CODE, COUNTRY]
	 * @param addressType The type
	 * @param value The value
	 */
	public Geocoding addComponent(String addressType, String value) {
		components.add(addressType.toLowerCase() + ":" + value);
		return this;
	}
}
