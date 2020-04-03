package com.example.jsonapp;

import java.util.HashSet;
import java.util.Set;


public class Features {
    String type;
    Set<String> properties = new HashSet<String>();

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


