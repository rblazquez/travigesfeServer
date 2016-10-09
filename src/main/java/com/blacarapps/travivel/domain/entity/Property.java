package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.blacarapps.travivel.domain.PROPERTY_TYPE;

@Entity
@Data
@NoArgsConstructor
public class Property implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
	@Column(unique=true)
	protected String name;
	
	@Enumerated(EnumType.STRING)
	protected PROPERTY_TYPE type;
	
	protected String description;
	
	@Min(0)	protected Integer maxGuest;
	@Min(0)	protected Integer bedRooms;
	@Min(0) protected Integer bathRooms;
	@Min(0) protected Integer amountOfBed;
	@Min(0) protected Integer minimumStay;
	@Min(0) protected Integer maximumStay;
	protected BigDecimal pricePerNight;
	protected BigDecimal cleaningFee;
	protected BigDecimal deposit;
	protected String streetAddress;
	protected String postalCode;
	protected String city;
	protected String stateProvince;
	protected String lat;
	protected String lng;
	protected Boolean active;
	protected String notes;

	@OneToMany(mappedBy="property",targetEntity=Attachment.class,
		       fetch=FetchType.EAGER)
	protected List<Attachment> attchments;
	
	@OneToMany(mappedBy="property",targetEntity=Booking.class,
		       fetch=FetchType.EAGER)
	protected List<Booking> bookings;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="PROPERTY_AMENITIES",
            joinColumns=
            @JoinColumn(name="PROPERTY_ID", referencedColumnName="ID"),
      inverseJoinColumns=
            @JoinColumn(name="AMENITIE_ID", referencedColumnName="ID")
    )
	protected List<Amenitie> amenities; 
	
	public Property(String name, PROPERTY_TYPE type, String description,
			Integer maxGuest, Integer bedRooms, Integer bathRooms,
			Integer amountOfBed, Integer minimumStay, Integer maximumStay,
			BigDecimal pricePerNight, BigDecimal cleaningFee,
			BigDecimal deposit, String streetAddress, String postalCode,
			String city, String stateProvince, String lat, String lng,
			Boolean active, String notes) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.maxGuest = maxGuest;
		this.bedRooms = bedRooms;
		this.bathRooms = bathRooms;
		this.amountOfBed = amountOfBed;
		this.minimumStay = minimumStay;
		this.maximumStay = maximumStay;
		this.pricePerNight = pricePerNight;
		this.cleaningFee = cleaningFee;
		this.deposit = deposit;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.lat = lat;
		this.lng = lng;
		this.active = active;
		this.notes = notes;
	}	
}
