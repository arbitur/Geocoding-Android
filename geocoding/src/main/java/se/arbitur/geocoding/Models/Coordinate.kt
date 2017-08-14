package se.arbitur.geocoding.Models


data class Coordinate(val latitude: Double, val longitude: Double) {
	override fun toString(): String = "$latitude,$longitude"
}