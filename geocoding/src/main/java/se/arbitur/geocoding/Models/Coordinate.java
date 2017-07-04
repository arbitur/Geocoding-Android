package se.arbitur.geocoding.Models;



public final class Coordinate {
	Double latitude;
	Double longitude;



	public Coordinate(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude() { return latitude; }
	public Double getLongitude() { return longitude; }

	@Override
	public String toString() { return latitude + "," + longitude; }
}
