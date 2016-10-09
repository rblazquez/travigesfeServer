package com.blacarapps.travivel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blacarapps.travivel.ApiTrvvlApplication;
import com.blacarapps.travivel.domain.builder.BookingBuilder;
import com.blacarapps.travivel.domain.builder.PropertyBuilder;
import com.blacarapps.travivel.domain.entity.Booking;
import com.blacarapps.travivel.domain.entity.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiTrvvlApplication.class)
public class BookingRepositoryTests {
	Logger log = LoggerFactory.getLogger(BookingRepositoryTests.class);

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Test
	@DirtiesContext
	public void findByPropertyIdTest() {
		// Given a property in db
		Property p = new PropertyBuilder().build();
		Property savedP = propertyRepository.save(p);
		long propertyId = savedP.getId();
		assertNotNull(propertyId);

		// and a booking
		BookingBuilder bb = new BookingBuilder();
		Booking b = bb.withProperty(p).build();
		bookingRepository.save(b);

		// when using find by property
		List<Booking> foundBookingList = bookingRepository
				.findByPropertyId(propertyId);

		// then foundBookingList has 1 item
		assertNotNull(foundBookingList);
		assertTrue(foundBookingList.size() == 1);
	}

	@SuppressWarnings("deprecation")
	@DirtiesContext
	@Test
	public void findBookingsAtTest() {
		// Given a property in db
		Property p = new PropertyBuilder().build();
		Property savedP = propertyRepository.save(p);
		long propertyId = savedP.getId();
		assertNotNull(propertyId);

		// and a booking
		BookingBuilder bb = new BookingBuilder();

		Booking b = bb.withProperty(p).withStartDate(new Date(2016, 10, 01))
				.withEndDate(new Date(2016, 10, 05)).build();

		bookingRepository.save(b);

		// when using find by property
		List<Booking> foundBookingList = bookingRepository
				.findBookingsAt(new Date(2016, 10, 02));
		List<Booking> foundBookingBefore = bookingRepository
				.findBookingsAt(new Date(2016, 9, 30));
		List<Booking> foundBookingAfter = bookingRepository
				.findBookingsAt(new Date(2016, 10, 10));

		// then foundBookingList has 1 item
		assertNotNull(foundBookingList);
		assertTrue(foundBookingList.size() == 1);

		assertNotNull(foundBookingBefore);
		assertTrue(foundBookingBefore.size() == 0);

		assertNotNull(foundBookingAfter);
		assertTrue(foundBookingAfter.size() == 0);
	}

	@SuppressWarnings("deprecation")
	@DirtiesContext
	@Test
	public void findBookingsForPropertyAndDateTest() {
		// Given a property in db
		Property p = new PropertyBuilder().build();
		Property savedP = propertyRepository.save(p);
		long propertyId = savedP.getId();
		assertNotNull(propertyId);

		// and a booking
		BookingBuilder bb = new BookingBuilder();

		Booking b = bb.withProperty(p).withStartDate(new Date(2016, 10, 01))
				.withEndDate(new Date(2016, 10, 05)).build();
		bookingRepository.save(b);

		Property p2 = new PropertyBuilder().build();
		Property savedP2 = propertyRepository.save(p2);
		long propertyId2 = savedP2.getId();
		assertNotNull(propertyId2);

		// when using find by property
		List<Booking> foundBookingList = bookingRepository
				.findBookingsForPropertyAndDate(propertyId, new Date(2016, 10,
						02));
		List<Booking> foundBookingBefore = bookingRepository
				.findBookingsForPropertyAndDate(propertyId, new Date(2016, 9,
						30));
		List<Booking> foundBookingAfter = bookingRepository
				.findBookingsForPropertyAndDate(propertyId, new Date(2016, 10,
						10));
		List<Booking> foundBookingEmpty = bookingRepository
				.findBookingsForPropertyAndDate(propertyId2, new Date(2016, 10,
						02));

		// then foundBookingList has 1 item
		log.error("ListSize: " + foundBookingList.size());
		assertNotNull(foundBookingList);
		assertTrue(foundBookingList.size() == 1);

		assertNotNull(foundBookingBefore);
		assertTrue(foundBookingBefore.size() == 0);

		assertNotNull(foundBookingAfter);
		assertTrue(foundBookingAfter.size() == 0);

		assertNotNull(foundBookingEmpty);
		assertTrue(foundBookingEmpty.size() == 0);
	}
}
