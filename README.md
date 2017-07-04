# Geocoding-Android

This is a Java wrapper for Google's [Geocoding Web API](https://developers.google.com/maps/documentation/geocoding)

## Install

> Root build.gradle
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

> Module build.gradle
```gradle
dependencies {
	compile 'com.github.arbitur:Geocoding-Android:1.0.1'
}
```

## Usage

#### Geocoding (Query search)

```java
new Geocoding(query, apiKey /* or null */)
    .setLanguage(language)
    .setBounds(new Bounds(sw, ne))
    .setRegion(region)
    .addComponent(type, value)
    ...
    .fetch(...);
```

#### Reverse Geocoding (Coordinate search)

```java
new ReverseGeocoding(coordinate, apiKey /* or null */)
    .setLanguage(language)
    .setResultTypes(resultType1, resultType2 ...)
    .setLocationTypes(locationType1, locationType2 ...)
    .isSensor(isSensor)
    .fetch(...);
```

#### Reverse Geocoding (Place ID search)

```java
new ReverseGeocoding(placeId, apiKey /* or null */)
    .setLanguage(language)
    .fetch(...);
```

## Examples

```java
new Geocoding("Stockholm", key) // City
    .setLanguage("sv")
    .setRegion("se")
    .addComponent(AddressTypes.COUNTRY, "Sweden")
    .fetch(...);
    

new Geocoding("Humlegården", key) // Park
    .setLanguage("sv")
    .addComponent(AddressTypes.ADMINISTRATIVE_AREA_LEVEL_1, "Stockholm")
    .fetch(...);
    

new Geocoding("Östermalmstorg 1, Stockholm, Sweden", key) // Street Address
    .setLanguage("sv")
    .setBounds(new Bounds(59.3, 18.01, 59.354, 18.116))
    .fetch(...);


new ReverseGeocoding(59.336, 18.079, apiKey)
    .setLanguage("sv")
    .setResultTypes(AdressTypes.STREET_ADDRESS)
    .setLocationTypes(LocationTypes.ROOF_TOP)
    .isSensor(true)
    .fetch(...);
```

#### Fetching

```java
...
.fetch(new Callback() {
    @Override
    public void onResponse(Response response) {
        for (Result result : response.getResults()) {
            Log.d(TAG, result.getFormattedAddress());
            
            addMarkerTo(result.getGeometry().getLocation())
        }
        
        Result[] addresses = response.getResults(AddressTypes.STREET_ADDRESS);
        Result[] routes = response.getResults(AddressTypes.ROUTE);
        
        ...
    }
        
    @Override
    public void onFailed(Response response, IOException exception) {
        Log.d(TAG, "Something went wrong");
    }
})
```
