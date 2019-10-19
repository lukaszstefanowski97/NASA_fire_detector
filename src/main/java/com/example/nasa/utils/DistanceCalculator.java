package com.example.nasa.utils;

public class DistanceCalculator {

    /**
     * @return distance in meters
     */
    public static Long calculate(Double sourceLat, Double sourceLon, Double destinationLat, Double destinationLon) {
        Long earthRadiusM = 6_371_000L;

        Double dLat = Math.toRadians(destinationLat - sourceLat);
        Double dLon = Math.toRadians(destinationLon - sourceLon);

        sourceLat = Math.toRadians(sourceLat);
        destinationLat = Math.toRadians(destinationLat);

        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(sourceLat) * Math.cos(destinationLat);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (long) (earthRadiusM * c);
    }
}
