package se.arbitur.geocoding


import okhttp3.HttpUrl
import se.arbitur.geocoding.Models.Bounds
import java.util.ArrayList



class AddressGeocoder(val query: String, key: String?): Geocoder(key) {

	private var bounds: Bounds? = null
	private var region: String? = null
	private val components: MutableList<String> = ArrayList()



	override val urlBuilder: HttpUrl.Builder
		get() {
			val builder = defaultUrlBuilder.addQueryParameter("address", query)
			if (bounds != null) 	builder.addQueryParameter("bounds", bounds.toString())
			if (region != null) 	builder.addQueryParameter("region", region)
			if (components.isNotEmpty())
				builder.addQueryParameter("components", components.joinToString("|"))

			return builder
		}


	/**
	 * Set language for values.
	 * [List of supported languages](https://developers.google.com/maps/faq#languagesupport)
	 * @param language Language code ex: "en", "sv"
	 */
	fun setLanguage(language: String): AddressGeocoder {
		this.language = language
		return this
	}

	/**
	 * Set prioritized bounds, searches within bounds first
	 * @param bounds The bounds, southWest -> northEast
	 * @return
	 */
	fun setBounds(bounds: Bounds): AddressGeocoder {
		this.bounds = bounds
		return this
	}

	/**
	 * Set the region
	 * @param region a ccTLD (Country Code Top Level Domain) ex: uk, es, us
	 */
	fun setRegion(region: String): AddressGeocoder {
		this.region = region
		return this
	}

	/**
	 * Add a component.
	 * Available types are [AddressTypes][se.arbitur.geocoding.Constants.AddressTypes].ROUTE, LOCALITY, ADMINISTRATIVE_AREA, POSTAL_CODE, COUNTRY
	 * @param type The address type
	 * @param value The value
	 */
	fun addComponent(type: String, value: String): AddressGeocoder {
		components.add(type.toLowerCase() + ":" + value)
		return this
	}
}