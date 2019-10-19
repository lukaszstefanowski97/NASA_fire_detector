package com.example.nasa.utils;

public class DistanceCalculator {

    /**
     * @return distance in meters
     */
    public static long calculate(double sourceLat, double sourceLon, double destinationLat, double destinationLon){
        long earthRadiusM = 6_371_000;

        double dLat = Math.toRadians(destinationLat-sourceLat);
        double dLon = Math.toRadians(destinationLon-sourceLon);

        sourceLat = Math.toRadians(sourceLat);
        destinationLat = Math.toRadians(destinationLat);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(sourceLat) * Math.cos(destinationLat);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return (long) (earthRadiusM * c);
    }
}
