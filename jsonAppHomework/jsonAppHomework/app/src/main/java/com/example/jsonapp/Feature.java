package com.example.jsonapp;

import java.util.HashSet;
import java.util.Set;


public class Feature {
    String type;
    Set<String> properties = new HashSet<String>();
    Geometry geometry;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<String> getProperties() {
        return properties;
    }

    public void setProperties(Set<String> properties) {
        this.properties = properties;
    }
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
