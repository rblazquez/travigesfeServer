package com.blacarapps.travivel.domain.builder;

import java.math.BigDecimal;
import java.util.Random;

import com.blacarapps.travivel.domain.PROPERTY_TYPE;
import com.blacarapps.travivel.domain.entity.Property;

// BUILDER
public class PropertyBuilder extends Property {
	Random randomno = new Random();
	
	public PropertyBuilder() {
		this.name = "Test Property " + randomno.nextInt(1000);
		this.type = PROPERTY_TYPE.FLAT;
		this.description = null;
		this.maxGuest = randomno.nextInt(10);
		this.bedRooms = randomno.nextInt(10);
		this.bathRooms = randomno.nextInt(10);
		this.amountOfBed = randomno.nextInt(10);
		this.minimumStay = randomno.nextInt(10);
		this.maximumStay = randomno.nextInt(10);
		this.pricePerNight = new BigDecimal("24.45");
		this.cleaningFee = new BigDecimal("4.45");
		this.deposit = new BigDecimal("44.45");
		this.streetAddress = "test address 33";
		this.postalCode = "38005";
		this.city = "City Test";
		this.stateProvince = "Test state";
		this.lat = null;
		this.lng = null;
		this.active = true;
		this.notes = null;
	}

	public PropertyBuilder withId(long idparam) {
		this.id = idparam;
		return this;		
	}

	public PropertyBuilder withName(String nameparam) {
		this.name = nameparam;
		return this;
	}

	public PropertyBuilder withType(PROPERTY_TYPE typeParam) {
		this.type = typeParam;
		return this;
	}
	
	public PropertyBuilder withDescription(String descriptionParam) {
		this.description = descriptionParam;
		return this;
	}	
	
	public PropertyBuilder withMaxGuest(int maxGuestParam) {
		this.maxGuest = maxGuestParam;
		return this;
	}	
	
	public PropertyBuilder withBedRooms(int bedRoomsParam) {
		this.bedRooms = bedRoomsParam;
		return this;
	}
	
	public PropertyBuilder withBathRooms(int bathRoomsParam) {
		this.bathRooms = bathRoomsParam;
		return this;
	}	
	
	public PropertyBuilder withAmountOfBed(int amountOfBedParam) {
		this.amountOfBed = amountOfBedParam;
		return this;
	}			

	public PropertyBuilder withMinimumStay(int minimumStayParam) {
		this.minimumStay = minimumStayParam;
		return this;
	}	
	
	public PropertyBuilder withMaximumStay(int maximumStayParam) {
		this.maximumStay = maximumStayParam;
		return this;
	}	
	
	public PropertyBuilder withPricePerNight(BigDecimal pricePerNightparam) {
		this.pricePerNight = pricePerNightparam;
		return this;
	}
	
	public PropertyBuilder withCleaningFee(BigDecimal cleaningFeeparam) {
		this.cleaningFee = cleaningFeeparam;
		return this;
	}
	
	public PropertyBuilder withDeposit(BigDecimal depositparam) {
		this.deposit = depositparam;
		return this;
	}		
	
	public PropertyBuilder withStreetAddress(String streetAddressParam) {
		this.streetAddress = streetAddressParam;
		return this;
	}		

	public PropertyBuilder withPostalCode(String postalCodeParam) {
		this.postalCode = postalCodeParam;
		return this;
	}	
	
	public PropertyBuilder withCity(String cityParam) {
		this.city = cityParam;
		return this;
	}	
	
	public PropertyBuilder withStateProvince(String stateProvinceParam) {
		this.stateProvince = stateProvinceParam;
		return this;
	}	
	
	public PropertyBuilder withLat(String latParam) {
		this.lat = latParam;
		return this;
	}			
	
	public PropertyBuilder withLng(String lngParam) {
		this.lng = lngParam;
		return this;
	}			
	
	public PropertyBuilder withActive(boolean activeParam) {
		this.active = activeParam;
		return this;
	}	
	
	public PropertyBuilder withNotes(String notesParam) {
		this.notes = notesParam;
		return this;
	}			
	
	public Property build() {
		return new Property(name, type, description,
				maxGuest, bedRooms, bathRooms,
				amountOfBed, minimumStay, maximumStay,
				pricePerNight, cleaningFee,
				deposit, streetAddress, postalCode,
				city, stateProvince, lat, lng,
				active, notes);
	}
}		
