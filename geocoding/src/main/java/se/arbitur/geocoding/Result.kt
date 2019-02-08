package se.arbitur.geocoding


import org.json.JSONObject
import se.arbitur.geocoding.models.Coordinate



class Result(json: JSONObject) {

	val addressComponents: Array<AddressComponent>
	val formattedAddress: String = json.getString("formatted_address")
	val geometry: Geometry = Geometry(json.getJSONObject("geometry"))
	val addressTypes: Array<String>
	val placeId: String = json.getString("place_id")



	init {
		val addressComponents = json.getJSONArray("address_components")
		this.addressComponents = (0 until addressComponents.length()).map { AddressComponent(addressComponents.getJSONObject(it)) }.toTypedArray()

		val addressTypes = json.getJSONArray("types")
		this.addressTypes = (0 until addressTypes.length()).map { addressTypes.getString(it) }.toTypedArray()
	}



	fun filterAddressComponents(type: String): Array<AddressComponent> = addressComponents.filter {
			it.addressTypes.contains(type)
		}.toTypedArray()



	class AddressComponent(json: JSONObject) {
		val longName: String = json.getString("long_name")
		val shortName: String = json.getString("short_name")
		val addressTypes: Array<String>

		init {
			val addressTypes = json.getJSONArray("types")
			this.addressTypes = (0 until addressTypes.length()).map { addressTypes.getString(it) }.toTypedArray()
		}
	}



	class Geometry(json: JSONObject) {
		val location: Coordinate
		val locationType: String = json.getString("location_type")
		val viewport: Viewport = Viewport(json.getJSONObject("viewport"))

		init {
			val jsonLocation = json.getJSONObject("location")
			location = Coordinate(jsonLocation.getDouble("lat"), jsonLocation.getDouble("lng"))
		}

		class Viewport(json: JSONObject) {
			val southWest: Coordinate
			val northEast: Coordinate

			init {
				val jsonSW = json.getJSONObject("southwest")
				southWest = Coordinate(jsonSW.getDouble("lat"), jsonSW.getDouble("lng"))

				val jsonNE = json.getJSONObject("northeast")
				northEast = Coordinate(jsonNE.getDouble("lat"), jsonNE.getDouble("lng"))
			}
		}
	}
}
