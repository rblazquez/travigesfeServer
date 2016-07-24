package com.blacarapps.travivel;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.blacarapps.travivel.domain.entity.Amenitie;
import com.blacarapps.travivel.domain.entity.Booking;
import com.blacarapps.travivel.domain.entity.Property;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Amenitie.class, Property.class, Booking.class);
    }
}
