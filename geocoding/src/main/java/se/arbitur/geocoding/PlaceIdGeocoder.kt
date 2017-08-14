package se.arbitur.geocoding

import okhttp3.HttpUrl



class PlaceIdGeocoder(val placeId: String, key: String?): Geocoder(key) {

	override val urlBuilder: HttpUrl.Builder
		get() = defaultUrlBuilder.addQueryParameter("place_id", placeId)


	/**
	 * Set language for values.
	 * [List of supported languages](https://developers.google.com/maps/faq.languagesupport)

	 * @param language Language code ex: "en", "sv"
	 */
	fun setLanguage(language: String?): PlaceIdGeocoder {
		this.language = language
		return this
	}
}