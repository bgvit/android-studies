package com.example.jsonapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeoJson {
    String type;
    Features features;
    Geometry geometry;

    public GeoJson(){
    }
    public GeoJson(String type, Features features, Geometry geometry){
        this.type = type;
        this.features = features;
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        features = features;
    }

    public Geometry getGeometry() {
        return geometry;
    }
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    /*
    {
  "type": "FeatureCollection",
  "features": [
    {
      "type": "Feature",
      "properties": {},
      "geometry": {
        "type": "Point",
        "coordinates": [
          -43.17156225442886,
          -22.90876700878904
        ]
      }
    }
  ]
}
    * */
}
