package se.arbitur.geocoding;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import se.arbitur.geocoding.Models.Coordinate;



public final class Result {
	@SerializedName("address_components") AddressComponent[] addressComponents;
	@SerializedName("formatted_address") String formattedAddress;
	@SerializedName("geometry") Geometry geometry;
	@SerializedName("types") String[] addressTypes;
	@SerializedName("place_id") String placeId;


	public Geometry getGeometry() {
		return geometry;
	}

	public AddressComponent[] getAddressComponents() {
		return addressComponents;
	}

	public String[] getAddressTypes() {
		return addressTypes;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public String getPlaceId() {
		return placeId;
	}

	public AddressComponent[] getAddressComponents(String addressType) {
		List<AddressComponent> filter = new ArrayList<>();

		for (AddressComponent component : getAddressComponents())
			for (int i = 0; i < component.getAddressTypes().length; i++) {
				String type = component.getAddressTypes()[i];
				if (type.equals(addressType)) {
					filter.add(component);
					break;
				}
			}

		return filter.toArray(new AddressComponent[filter.size()]);
	}





	public static final class AddressComponent {
		@SerializedName("long_name") String longName;
		@SerializedName("short_name") String shortName;
		@SerializedName("types") String[] addressTypes;


		public String[] getAddressTypes() {
			return addressTypes;
		}

		public String getLongName() {
			return longName;
		}

		public String getShortName() {
			return shortName;
		}
	}





	public static final class Geometry {
		@SerializedName("location") Coordinate location;
		@SerializedName("location_type") String locationType;
		@SerializedName("viewport") Viewport viewport;


		public Coordinate getLocation() {
			return location;
		}

		public String getLocationType() {
			return locationType;
		}

		public Viewport getViewport() {
			return viewport;
		}




		public static final class Viewport {
			@SerializedName("southwest") Coordinate southWest;
			@SerializedName("northeast") Coordinate northEast;


			public Coordinate getNorthEast() {
				return northEast;
			}

			public Coordinate getSouthWest() {
				return southWest;
			}
		}
	}
}
