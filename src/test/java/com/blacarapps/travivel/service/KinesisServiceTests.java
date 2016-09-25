package com.blacarapps.travivel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blacarapps.travivel.ApiTrvvlApplication;
import com.blacarapps.travivel.domain.events.DwhEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiTrvvlApplication.class)
public class KinesisServiceTests {
	@Autowired
	KinesisService kinesisService;
	
	@Test
	public void handleAmenitieSave() {
		DwhEvent dwh = new DwhEvent();
		dwh.setTestfield("1234");
		kinesisService.sendMessage(dwh.toString());
	}
}
