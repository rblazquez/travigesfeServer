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
	protected Long id;

	protected String name;
	protected String description;

	public Amenitie() {
	}

	public Amenitie(String name) {
		this.name = name;
	}

	public Amenitie(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
}
