package com.blacarapps.travivel.domain.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.blacarapps.travivel.domain.entity.Booking;
import com.blacarapps.travivel.service.KinesisService;

@RepositoryEventHandler
public class BookingEventHandler {
	@Autowired
	KinesisService kinesisService;

	@HandleAfterSave
	public void handleBookingSave(Booking p) {
		DwhEvent dwh = new DwhEvent();
		dwh.setTestfield("1234");
		kinesisService.sendMessage(dwh.toString());
	}
}
