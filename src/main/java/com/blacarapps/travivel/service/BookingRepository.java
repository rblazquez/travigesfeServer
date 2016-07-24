package com.blacarapps.travivel.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.blacarapps.travivel.domain.BOOKING_STATUS;
import com.blacarapps.travivel.domain.entity.Booking;

public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {
	List<Booking> findByCode(@Param("code") String code);
	List<Booking> findByStartDateBetween(@Param("startDatePeriod") @DateTimeFormat(iso = ISO.DATE) Date startDate, @Param("endDatePeriod") @DateTimeFormat(iso = ISO.DATE) Date endDate);
	List<Booking> findByEndDateBetween(@Param("startDatePeriod") @DateTimeFormat(iso = ISO.DATE) Date startDate, @Param("endDatePeriod") @DateTimeFormat(iso = ISO.DATE) Date endDate);	
	List<Booking> findByStatus(@Param("status") BOOKING_STATUS status);
}
