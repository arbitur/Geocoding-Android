package se.arbitur.geocoding;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public final class Response {
	Result[] results;
	String status;
	String errorMessage;


	public Result[] getResults() 		{ return results; }
	public String 	getStatus() 		{ return status; }
	public String 	getErrorMessage() 	{ return errorMessage; }

	public Result[] getResults(String addressType) {
		List<Result> filter = new ArrayList<>();

		for (Result result : getResults())
			for (int i = 0; i < result.getAddressTypes().length; i++) {
				String type = result.getAddressTypes()[i];
				if (type.equals(addressType)) {
					filter.add(result);
					break;
				}
			}

		return filter.toArray(new Result[filter.size()]);
	}


	protected Response(JSONObject json) throws JSONException {
		if (json.has("results")) {
			JSONArray jsonResults = json.getJSONArray("results");
			results = new Result[jsonResults.length()];
			for (int i = 0; i < jsonResults.length(); i++)
				results[i] = new Result(jsonResults.getJSONObject(i));
		}

		status = json.getString("status");

		if (json.has("error_message"))
			errorMessage = json.getString("error_message");
	}
}
