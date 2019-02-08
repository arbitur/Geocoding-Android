package se.arbitur.geocoding.constants



object AddressComponent {
    const val ROUTE 				= "route" 				// matches long or short name of a route.
    const val LOCALITY 				= "locality" 			// matches against both locality and sublocality types.
    const val ADMINISTRATIVE_AREA 	= "administrative_area" // matches all the administrative_area levels.
    const val POSTAL_CODE 			= "postal_code" 		// matches postal_code and postal_code_prefix.
    const val COUNTRY 				= "country" 			// matches a country name or a two letter ISO 3166-1 country code.
}



object AddressType {
    const val STREET_ADDRESS 				= "street_address" 					// a precise street address.
    const val ROUTE 						= "route" 							// a named route (such as "US 101").
    const val INTERSECTION 					= "intersection" 					// a major intersection, usually of two major roads.
    const val POLITICAL						= "political" 						// a political entity. Usually, this type indicates a polygon of some civil administration.
    const val COUNTRY 						= "country" 						// the national political entity, and is typically the highest order type returned by the Geocoder.
    const val ADMINISTRATIVE_AREA_LEVEL_1 	= "administrative_area_level_1" 	// a first-order civil entity below the country level. Within the United States, these administrative levels are states. Not all nations exhibit these administrative levels.
    const val ADMINISTRATIVE_AREA_LEVEL_2 	= "administrative_area_level_2" 	// a second-order civil entity below the country level. Within the United States, these administrative levels are counties. Not all nations exhibit these administrative levels.
    const val ADMINISTRATIVE_AREA_LEVEL_3 	= "administrative_area_level_3" 	// a third-order civil entity below the country level. This type indicates a minor civil division. Not all nations exhibit these administrative levels.
    const val ADMINISTRATIVE_AREA_LEVEL_4 	= "administrative_area_level_4" 	// a fourth-order civil entity below the country level. This type indicates a minor civil division. Not all nations exhibit these administrative levels.
    const val ADMINISTRATIVE_AREA_LEVEL_5 	= "administrative_area_level_5" 	// a fifth-order civil entity below the country level. This type indicates a minor civil division. Not all nations exhibit these administrative levels.
    const val COLLOQUIAL_AREA 				= "colloquial_area"				// a commonly-used alternative name for the entity.
    const val LOCALITY 						= "locality"						// an incorporated city or town political entity.
    const val WARD 							= "ward"							// a specific type of Japanese locality, to facilitate distinction between multiple locality components within a Japanese address.
    const val SUBLOCALITY 					= "sublocality"					// a first-order civil entity below a locality. For some locations may receive one of the additional types: sublocality_level_1 to sublocality_level_5. Each sublocality level is a civil entity. Larger numbers indicate a smaller geographic area.
    const val SUBLOCALITY_LEVEL_1 			= "sublocality_level_1"
    const val SUBLOCALITY_LEVEL_2 			= "sublocality_level_2"
    const val SUBLOCALITY_LEVEL_3 			= "sublocality_level_3"
    const val SUBLOCALITY_LEVEL_4 			= "sublocality_level_4"
    const val SUBLOCALITY_LEVEL_5 			= "sublocality_level_5"
    const val NEIGHBORHOOD 					= "neighborhood" 					// a named neighborhood
    const val PREMISE 						= "premise"  						// a named location, usually a building or collection of buildings with a common name
    const val SUBPREMISE 					= "subpremise" 						// a first-order entity below a named location, usually a singular building within a collection of buildings with a common name
    const val POSTAL_CODE 					= "postal_code" 					// a postal code as used to address postal mail within the country.
    const val NATURAL_FEATURE 				= "natural_feature" 				// a prominent natural feature.
    const val AIRPORT 						= "airport" 						// an airport.
    const val PARK 							= "park" 							// a named park.
    const val POINT_OF_INTEREST 			= "point_of_interest" 				// a named point of interest. Typically, these "POI"s are prominent local entities that don't easily fit in another category, such as "Empire State Building" or "Statue of Liberty."
    const val STREET_NUMBER 				= "street_number" 					// the precise street number.
    const val POSTAL_TOWN 					= "postal_town" 					// indicates a grouping of geographic areas, such as locality and sublocality, used for mailing addresses in some countries
}



object LocationType {
    const val ROOFTOP 				= "ROOFTOP" 			// addresses for which we have location information accurate down to street address precision.
    const val RANGE_INTERPOLATED 	= "RANGE_INTERPOLATED" 	// those that reflect an approximation (usually on a road) interpolated between two precise points (such as intersections). An interpolated range generally indicates that rooftop geocodes are unavailable for a street address.
    const val GEOMETRIC_CENTER 		= "GEOMETRIC_CENTER" 	// geometric centers of a location such as a polyline (for example, a street) or polygon (region).
    const val APPROXIMATE 			= "APPROXIMATE" 		// those that are characterized as approximate.
}



object ResponseStatus {
    const val OK 				= "OK"
    const val ZERO_RESULTS 		= "ZERO_RESULTS"
    const val OVER_QUERY_LIMIT 	= "OVER_QUERY_LIMIT"
    const val REQUEST_DENIED 	= "REQUEST_DENIED"
    const val INVALID_REQUEST 	= "INVALID_REQUEST"
    const val UNKNOWN_ERROR 	= "UNKNOWN_ERROR"
}

