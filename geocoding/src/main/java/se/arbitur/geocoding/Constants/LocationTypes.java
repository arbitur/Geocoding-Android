package se.arbitur.geocoding.Constants;


public interface LocationTypes {
	String ROOFTOP 				= "ROOFTOP";			// addresses for which we have location information accurate down to street address precision.
	String RANGE_INTERPOLATED 	= "RANGE_INTERPOLATED";	// those that reflect an approximation (usually on a road) interpolated between two precise points (such as intersections). An interpolated range generally indicates that rooftop geocodes are unavailable for a street address.
	String GEOMETRIC_CENTER 	= "GEOMETRIC_CENTER";	// geometric centers of a location such as a polyline (for example, a street) or polygon (region).
	String APPROXIMATE 			= "APPROXIMATE";		// those that are characterized as approximate.
}
