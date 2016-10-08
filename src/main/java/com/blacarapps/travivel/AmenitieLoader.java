package com.blacarapps.travivel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.blacarapps.travivel.domain.entity.Amenitie;
import com.blacarapps.travivel.service.AmenitieRepository;

@Component
public class AmenitieLoader implements
		ApplicationListener<ContextRefreshedEvent> {

	private AmenitieRepository amenitieRepository;

	@Autowired
	public void setAmenitieRepository(AmenitieRepository amenitieRepository) {
		this.amenitieRepository = amenitieRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (amenitieRepository.count() == 0) {
			Amenitie amenitie = new Amenitie("Kitchen");
			amenitieRepository.save(amenitie);

			amenitie = new Amenitie("Internet");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("TV");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Essentials");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Shampoo");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Heating");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Air Conditioning");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Washer");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Dryer");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Free Parking");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Wireless Internet");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Cable TV");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Breakfast");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Pets Allowed");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Family/Kids Friendly");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Suitable for events");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Smoking Allowed");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Wheelchair Accessible");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Elevator in Building");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Indoor Fireplace");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Doorman");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Pool");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Hot Tub");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Gym");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("24h Check-in");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Hangers");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Iron");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Hair Dryer");
			amenitieRepository.save(amenitie);
			amenitie = new Amenitie("Laptop Friendly workspace");
			amenitieRepository.save(amenitie);
		}
	}
}
