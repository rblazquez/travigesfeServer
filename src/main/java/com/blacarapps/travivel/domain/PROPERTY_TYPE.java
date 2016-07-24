package com.blacarapps.travivel.domain;

public enum PROPERTY_TYPE {
	ROOM("Room"),
	FLAT("Flat"),
	HOUSE("House");
	
    final String value;

    PROPERTY_TYPE(String value) { this.value = value; }

    @Override
	public String toString() { return value; } 
    String getKey() { return name(); }
}
