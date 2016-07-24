package com.blacarapps.travivel.domain;

public enum ATTACHMENT_TYPE {
	PICTURE("Picture"),
	DOCUMENT("Document");
	
	final String value;

	ATTACHMENT_TYPE(String value) { this.value = value; }

	@Override
	public String toString() { return value; }
	
	String getKey() { return name(); }
}
