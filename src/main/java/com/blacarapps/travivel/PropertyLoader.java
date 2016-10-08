package com.blacarapps.travivel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.blacarapps.travivel.domain.BOOKING_STATUS;
import com.blacarapps.travivel.domain.PROPERTY_TYPE;
import com.blacarapps.travivel.domain.entity.Amenitie;
import com.blacarapps.travivel.domain.entity.Booking;
import com.blacarapps.travivel.domain.entity.Property;
import com.blacarapps.travivel.service.AmenitieRepository;
import com.blacarapps.travivel.service.BookingRepository;
import com.blacarapps.travivel.service.PropertyRepository;

@Component
public class PropertyLoader implements
		ApplicationListener<ContextRefreshedEvent> {

	private PropertyRepository propertyRepository;
	private AmenitieRepository amenitieRepository;
	private BookingRepository bookingRepository;

	@Autowired
	public void setPropertyRepository(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Autowired
	public void setAmenitieRepository(AmenitieRepository amenitieRepository) {
		this.amenitieRepository = amenitieRepository;
	}

	@Autowired
	public void setBookingRepository(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (propertyRepository.count() == 0) {
			Property property = new Property("Pinke", PROPERTY_TYPE.HOUSE,
					"Amazing Canarian house", 10, 5, 3, 5, 5, 30,
					new BigDecimal("29.95"), new BigDecimal("9.99"),
					new BigDecimal("450.00"), "", "", "", "", null, null, true,
					null);
			List<Amenitie> amenitieList = new ArrayList<>();

			Amenitie amenitie = new Amenitie("Embedded");
			amenitie = amenitieRepository.save(amenitie);
			amenitieList.add(amenitie);
			property.setAmenities(amenitieList);
			propertyRepository.save(property);

			property = new Property("Costamar 405", PROPERTY_TYPE.FLAT,
					"Amazing Canarian apartment", 4, 2, 1, 2, 2, 10,
					new BigDecimal("19.95"), new BigDecimal("9.99"),
					new BigDecimal("150.00"), "", "", "", "", null, null, true,
					null);
			property = propertyRepository.save(property);

			Booking booking = new Booking("BOOKING1", new Date(), new Date(),
					2, new BigDecimal(33.95d), new BigDecimal(12.00),
					new BigDecimal(450.50), BOOKING_STATUS.REQUESTED, "none",
					"none", property);
			bookingRepository.save(booking);
		}
	}

}
