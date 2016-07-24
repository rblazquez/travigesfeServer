package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Amenitie implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String name;
	private String description;
	
	public Amenitie() {}
	
	public Amenitie(String name) {
		this.name = name;
	}
}
