package se.arbitur.geocoding;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public final class Response {
	@SerializedName("results") Result[] results;
	@SerializedName("status") String status;
	@SerializedName("error_message") String errorMessage;


	public Result[] getResults() { return results; }
	public String getStatus() { return status; }
	public String getErrorMessage() { return errorMessage; }

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

}
