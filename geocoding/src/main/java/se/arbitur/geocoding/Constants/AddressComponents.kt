package se.arbitur.geocoding.Constants


object AddressComponents {
	const val ROUTE 				= "route" 				// matches long or short name of a route.
	const val LOCALITY 				= "locality" 			// matches against both locality and sublocality types.
	const val ADMINISTRATIVE_AREA 	= "administrative_area" // matches all the administrative_area levels.
	const val POSTAL_CODE 			= "postal_code" 		// matches postal_code and postal_code_prefix.
	const val COUNTRY 				= "country" 			// matches a country name or a two letter ISO 3166-1 country code.
}