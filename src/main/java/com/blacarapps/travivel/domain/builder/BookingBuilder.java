package com.blacarapps.travivel.domain.builder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.blacarapps.travivel.domain.BOOKING_STATUS;
import com.blacarapps.travivel.domain.entity.Booking;
import com.blacarapps.travivel.domain.entity.Property;

// BUILDER
public class BookingBuilder extends Booking {
	Random randomno = new Random();
	
	public BookingBuilder() {
	    this.id = randomno.nextLong();
		this.code = UUID.randomUUID().toString();
		this.startDate = new Date();
		this.endDate = new Date();
		this.guestNo = randomno.nextInt(4);
		this.pricePerNight = new BigDecimal("24.45");
		this.cleaningFee = new BigDecimal("4.45");
		this.deposit = new BigDecimal("44.45");
		this.status = BOOKING_STATUS.REQUESTED;
		this.specialRequests = null;
		this.notes = null;
		this.property = new Property();
	}

	public BookingBuilder withId(long idparam) {
		this.id = idparam;
		return this;
	}

	public BookingBuilder withCode(String codeparam) {
		this.code = codeparam;
		return this;
	}

	public BookingBuilder withStartDate(Date startDateParam) {
		this.startDate = startDateParam;
		return this;
	}
	
	public BookingBuilder withEndDate(Date endDateParam) {
		this.endDate = endDateParam;
		return this;
	}	
	
	public BookingBuilder withGuestNo(int guestNoParam) {
		this.guestNo = guestNoParam;
		return this;
	}	
	
	public BookingBuilder withPricePerNight(BigDecimal pricePerNightParam) {
		this.pricePerNight = pricePerNightParam;
		return this;
	}
	
	public BookingBuilder withCleaningFee(BigDecimal cleaningFeeParam) {
		this.cleaningFee = cleaningFeeParam;
		return this;
	}	
	
	public BookingBuilder withDeposit(BigDecimal depositParam) {
		this.deposit = depositParam;
		return this;
	}			

	public BookingBuilder withStatus(BOOKING_STATUS statusParam) {
		this.status = statusParam;
		return this;
	}	
	
	public BookingBuilder withSpecialRequests(String specialRequestsParam) {
		this.specialRequests = specialRequestsParam;
		return this;
	}	
	
	public BookingBuilder withNotes(String notesparam) {
		this.notes = notesparam;
		return this;
	}	
	
	public BookingBuilder withProperty(Property propertyParam) {
		this.property = propertyParam;
		return this;
	}			
	
	public Booking build() {
		Booking b = new Booking(code, startDate, endDate, guestNo,
				pricePerNight, cleaningFee, deposit, status, specialRequests,
				notes, property);
		b.setId(this.id);
		return b;
	}
}	
