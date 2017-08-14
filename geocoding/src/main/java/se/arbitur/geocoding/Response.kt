package se.arbitur.geocoding


import org.json.JSONObject



class Response(json: JSONObject) {

	val results: Array<Result>?
	val errorMessage: String?
	val status: String = json.getString("status")


	init {
		if (json.has("results")) {
			val results = json.getJSONArray("results")
			this.results = (0 until results.length()).map { Result(results.getJSONObject(it)) }.toTypedArray()
		}
		else
			this.results = null

		if (json.has("error_message"))
			errorMessage = json.getString("error_message")
		else
			this.errorMessage = null
	}


	fun filterResults(type: String): Array<Result>? = results?.filter {
			it.addressTypes.contains(type)
		}!!.toTypedArray()
}