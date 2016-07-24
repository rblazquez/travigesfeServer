package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.blacarapps.travivel.domain.BOOKING_STATUS;


@Entity
@Data
@NoArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(unique=true)
	private String code;

	private Date startDate;
	private Date endDate;
	@Min(0)	private Integer guestNo;
	private BigDecimal pricePerNight;
	private BigDecimal cleaningFee;
	private BigDecimal deposit;
	
	@Enumerated(EnumType.STRING)
	private BOOKING_STATUS status;
	
	private String specialRequests;
	private String notes;
    
	@ManyToOne(cascade={CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name = "PROPERTY_ID", referencedColumnName = "id")
	private Property property;
	
	@OneToMany(mappedBy="booking",targetEntity=BookingEvent.class,
		       fetch=FetchType.EAGER)
	private List<BookingEvent> bookingEvents;
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name = "GUEST_ID", referencedColumnName = "id")
	private Guest guest;
	
	public Booking(String code, Date startDate, Date endDate, Integer guestNo,
			BigDecimal pricePerNight, BigDecimal cleaningFee,
			BigDecimal deposit, BOOKING_STATUS status, String specialRequests,
			String notes, Property property) {
		super();
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.guestNo = guestNo;
		this.pricePerNight = pricePerNight;
		this.cleaningFee = cleaningFee;
		this.deposit = deposit;
		this.status = status;
		this.specialRequests = specialRequests;
		this.notes = notes;
		this.property = property;
	}
}
