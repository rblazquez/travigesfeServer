package com.blacarapps.travivel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.blacarapps.travivel.domain.entity.Amenitie;
import com.blacarapps.travivel.domain.entity.Booking;
import com.blacarapps.travivel.domain.entity.Property;
import com.blacarapps.travivel.domain.events.AmenitieEventHandler;
import com.blacarapps.travivel.domain.events.BookingEventHandler;
import com.blacarapps.travivel.domain.events.PropertyEventHandler;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Amenitie.class, Property.class, Booking.class);
    }
    
	@Bean
	AmenitieEventHandler amenitieEventHandler() {
		return new AmenitieEventHandler();
	}
	
	@Bean
	PropertyEventHandler propertyEventHandler() {
		return new PropertyEventHandler();
	}
	
	@Bean
	BookingEventHandler bookingEventHandler() {
		return new BookingEventHandler();
	}	
}
