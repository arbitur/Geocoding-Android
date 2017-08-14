package se.arbitur.geocoding.Models


data class Bounds(val southWest: Coordinate, val northEast: Coordinate) {

	constructor(swLat: Double, swLong: Double, neLat: Double, neLong: Double):
			this(Coordinate(swLat, swLong), Coordinate(neLat, neLong))

	override fun toString(): String = "$southWest|$northEast"
}