package se.arbitur.geocoding.models



data class Coordinate(val latitude: Double, val longitude: Double) {

    override fun toString(): String =
            "$latitude,$longitude"
}


data class Bounds(val southWest: Coordinate, val northEast: Coordinate) {

    constructor(swLat: Double, swLong: Double, neLat: Double, neLong: Double):
            this(Coordinate(swLat, swLong), Coordinate(neLat, neLong))

    override fun toString(): String =
            "$southWest|$northEast"
}
