package com.example.jsonapp;

import java.util.List;

public class GeoJson {
    String type;
    List<Feature> featureList;
    Geometry geometry;

    public GeoJson(){
    }

    public GeoJson(String type, List<Feature> featureList, Geometry geometry){
        this.type = type;
        this.featureList = featureList;
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

/* MODELO DE JSON
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
