package se.arbitur.geocoding;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import se.arbitur.geocoding.Models.Coordinate;



public final class Result {
	AddressComponent[] addressComponents;
	String formattedAddress;
	Geometry geometry;
	String[] addressTypes;
	String placeId;



	protected Result(JSONObject json) throws JSONException {
		JSONArray jsonAddressComponents = json.getJSONArray("address_components");
		addressComponents = new AddressComponent[jsonAddressComponents.length()];
		for (int i = 0; i < jsonAddressComponents.length(); i++)
			addressComponents[i] = new AddressComponent(jsonAddressComponents.getJSONObject(i));

		formattedAddress = json.getString("formatted_address");
		geometry = new Geometry(json.getJSONObject("geometry"));

		JSONArray jsonAddressTypes = json.getJSONArray("types");
		addressTypes = new String[jsonAddressTypes.length()];
		for (int i = 0; i < jsonAddressTypes.length(); i++)
			addressTypes[i] = jsonAddressTypes.getString(i);

		placeId = json.getString("place_id");
	}


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
		String longName;
		String shortName;
		String[] addressTypes;


		protected AddressComponent(JSONObject json) throws JSONException {
			longName = json.getString("long_name");
			shortName = json.getString("short_name");

			JSONArray jsonTypes = json.getJSONArray("types");
			addressTypes = new String[jsonTypes.length()];
			for (int i = 0; i < jsonTypes.length(); i++)
				addressTypes[i] = jsonTypes.getString(i);
		}


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
		Coordinate location;
		String locationType;
		Viewport viewport;


		protected Geometry(JSONObject json) throws JSONException {
			JSONObject jsonLocation = json.getJSONObject("location");
			location = new Coordinate(jsonLocation.getDouble("lat"), jsonLocation.getDouble("lng"));

			locationType = json.getString("location_type");
			viewport = new Viewport(json.getJSONObject("viewport"));
		}


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
			Coordinate southWest;
			Coordinate northEast;


			protected Viewport(JSONObject json) throws JSONException {
				JSONObject jsonSW = json.getJSONObject("southwest");
				southWest = new Coordinate(jsonSW.getDouble("lat"), jsonSW.getDouble("lng"));

				JSONObject jsonNE = json.getJSONObject("northeast");
				northEast = new Coordinate(jsonNE.getDouble("lat"), jsonNE.getDouble("lng"));
			}


			public Coordinate getNorthEast() {
				return northEast;
			}

			public Coordinate getSouthWest() {
				return southWest;
			}
		}
	}
}
