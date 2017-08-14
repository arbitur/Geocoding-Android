package se.arbitur.geocoding.Constants


object AddressTypes {
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