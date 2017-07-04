package se.arbitur.geocoding.Models;


public final class Bounds {
	private Coordinate southWest;
	private Coordinate northEast;

	public Bounds(Coordinate southWest, Coordinate northEast) {
		this.southWest = southWest;
		this.northEast = northEast;
	}

	public Bounds(double swLat, double swLong, double neLat, double neLong) {
		southWest = new Coordinate(swLat, swLong);
		northEast = new Coordinate(neLat, neLong);
	}

	@Override
	public String toString() {
		return southWest.toString() + "|" + northEast.toString();
	}
}
