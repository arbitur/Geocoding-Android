package se.arbitur.geocoding.Models;


import com.google.gson.annotations.SerializedName;



public final class Coordinate {
	@SerializedName("lat") Double latitude;
	@SerializedName("lng") Double longitude;



	public Coordinate(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude() { return latitude; }
	public Double getLongitude() { return longitude; }

	@Override
	public String toString() { return latitude + "," + longitude; }
}
