package com.blacarapps.travivel.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.blacarapps.travivel.domain.entity.Amenitie;

public interface AmenitieRepository extends PagingAndSortingRepository<Amenitie, Long> {
	List<Amenitie> findByName(@Param("name") String name);
}
