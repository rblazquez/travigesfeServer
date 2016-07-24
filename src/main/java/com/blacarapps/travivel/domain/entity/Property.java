package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    private Long id;
    
	@Column(unique=true)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private PROPERTY_TYPE type;
	
	private String description;
	
	@Min(0)	private Integer maxGuest;
	@Min(0)	private Integer bedRooms;
	@Min(0) private Integer bathRooms;
	@Min(0) private Integer amountOfBed;
	@Min(0) private Integer minimumStay;
	@Min(0) private Integer maximumStay;
	private BigDecimal pricePerNight;
	private BigDecimal cleaningFee;
	private BigDecimal deposit;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String lat;
	private String lng;
	private Boolean active;
	private String notes;
	
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

	@OneToMany(mappedBy="property",targetEntity=Attachment.class,
		       fetch=FetchType.EAGER)
	private List<Attachment> attchments;
	
	@OneToMany(mappedBy="property",targetEntity=Booking.class,
		       fetch=FetchType.EAGER)
	private List<Booking> bookings;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="PROPERTY_AMENITIES",
            joinColumns=
            @JoinColumn(name="PROPERTY_ID", referencedColumnName="ID"),
      inverseJoinColumns=
            @JoinColumn(name="AMENITIE_ID", referencedColumnName="ID")
    )
	private List<Amenitie> amenities; 
}
