package com.blacarapps.travivel.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blacarapps.travivel.domain.entity.BookingEvent;

public interface BookingEventRepository extends PagingAndSortingRepository<BookingEvent, Long> {

}
