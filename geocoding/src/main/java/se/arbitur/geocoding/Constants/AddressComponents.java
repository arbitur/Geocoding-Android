package se.arbitur.geocoding.Constants;


public interface AddressComponents {
	String ROUTE 				= "route";					// matches long or short name of a route.
	String LOCALITY 			= "locality";				// matches against both locality and sublocality types.
	String ADMINISTRATIVE_AREA 	= "administrative_area";	// matches all the administrative_area levels.
	String POSTAL_CODE 			= "postal_code";			// matches postal_code and postal_code_prefix.
	String COUNTRY 				= "country";				// matches a country name or a two letter ISO 3166-1 country code.
}
