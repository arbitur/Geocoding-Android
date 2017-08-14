package se.arbitur.geocoding


import okhttp3.HttpUrl
import se.arbitur.geocoding.Models.Coordinate



class CoordinateGeocoder(val coordinate: Coordinate, key: String?): Geocoder(key) {

	private var resultTypes: Array<String>? = null
	private var locationTypes: Array<String>? = null
	private var isSensor: Boolean? = null



	constructor(latitude: Double, longitude: Double, key: String?) : this(Coordinate(latitude, longitude), key)



	override val urlBuilder: HttpUrl.Builder
		get() {
			val resultTypes = resultTypes
			val locationTypes = locationTypes

			val builder = defaultUrlBuilder.addQueryParameter("latlng", coordinate.toString())
			if (resultTypes != null) 	builder.addQueryParameter("result_type", resultTypes.joinToString("|").toLowerCase())
			if (locationTypes != null) 	builder.addQueryParameter("location_type=", locationTypes.joinToString("|").toLowerCase())
			if (isSensor != null) 		builder.addQueryParameter("sensor", isSensor!!.toString())
//				builder.addQueryParameter("place_id", placeId)

			return builder
		}



	/**
	 * Set language for values.
	 * [List of supported languages](https://developers.google.com/maps/faq.languagesupport)

	 * @param language Language code ex: "en", "sv"
	 */
	fun setLanguage(language: String?): CoordinateGeocoder {
		this.language = language
		return this
	}

	/**
	 * Set result types.
	 * Available types found in [AddressComponents][se.arbitur.geocoding.Constants.AddressComponents]
	 * @param types The types
	 */
	fun setResultTypes(vararg types: String): CoordinateGeocoder {
		this.resultTypes = arrayOf(*types)
		return this
	}

	/**
	 * Set location types.
	 * Available types found in [LocationTypes][se.arbitur.geocoding.Constants.LocationTypes]
	 * @param types The types
	 */
	fun setLocationTypes(vararg types: String): CoordinateGeocoder {
		this.locationTypes = arrayOf(*types)
		return this
	}

	/**
	 * Set isSensor
	 * @param isSensor If sensor
	 */
	fun isSensor(isSensor: Boolean): CoordinateGeocoder {
		this.isSensor = isSensor
		return this
	}
}