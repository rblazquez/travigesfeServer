package com.blacarapps.travivel.domain.builder;

import java.util.Random;

import com.blacarapps.travivel.domain.entity.Amenitie;

// BUILDER
public class AmenitieBuilder extends Amenitie {
	Random randomno = new Random();
	
	public AmenitieBuilder() {
	    id = randomno.nextLong();
	    name = "amenitie example";
	    description = "amenitie example";
	}

	public AmenitieBuilder withId(long idparam) {
		this.id = idparam;
		return this;
	}

	public AmenitieBuilder withName(String nameparam) {
		this.name = nameparam;
		return this;
	}

	public AmenitieBuilder withDescription(String descriptionparam) {
		this.description = descriptionparam;
		return this;
	}

	public Amenitie build() {
		return new Amenitie(id, name, description);
	}
}
