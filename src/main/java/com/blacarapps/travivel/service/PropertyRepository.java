package com.blacarapps.travivel.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blacarapps.travivel.domain.entity.Property;

public interface PropertyRepository extends PagingAndSortingRepository<Property, Long> {

}
