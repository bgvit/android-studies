package com.example.jsonapp;

public class Geometry {
    String type;

    double[] coordinates = new double[1];

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getLatitude() {
        return coordinates[0];
    }

    public double getLongitude() {
        return coordinates[1];
    }
}
