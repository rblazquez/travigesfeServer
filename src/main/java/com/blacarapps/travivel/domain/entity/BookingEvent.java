package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import com.blacarapps.travivel.domain.BOOKING_EVENT_TYPE;

@Entity
@Data
public class BookingEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Booking booking;
	
	@Enumerated(EnumType.STRING)
	private BOOKING_EVENT_TYPE type;
	
	private Date eventTime;
	private String notes;
}
