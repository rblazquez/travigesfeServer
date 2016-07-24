package com.blacarapps.travivel.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blacarapps.travivel.domain.entity.Guest;

public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {
}
