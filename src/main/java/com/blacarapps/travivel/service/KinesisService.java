package com.blacarapps.travivel.service;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClient;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.PutRecordResult;
import com.amazonaws.services.kinesisfirehose.model.Record;
import com.blacarapps.travivel.KinesisProp;

@Component
public class KinesisService {
	private static final Logger logger = LoggerFactory
			.getLogger(KinesisService.class);
	@Autowired
	private KinesisProp kinesisProp;
	private AmazonKinesisFirehoseClient kinesisClient;

	@PostConstruct
	private void init() {
		try {
			instantiateKinesisClient();
		} catch (Exception e) {
			logger.error(
					"Exception occurred while instantiating the Kinesis Client",
					e);
		}
	}

	private void instantiateKinesisClient() throws IOException {
		BasicAWSCredentials credentials = new BasicAWSCredentials(
				this.kinesisProp.getAwsAccessKey(),
				this.kinesisProp.getAwsSecretKey());
		kinesisClient = new AmazonKinesisFirehoseClient(credentials);
		final Region apac_east = Region.getRegion(Regions.EU_WEST_1);
		kinesisClient.setRegion(apac_east);
	}

	public void sendMessage(final String message) throws AmazonServiceException {
		PutRecordRequest putRecordRequest = new PutRecordRequest();
		putRecordRequest.setDeliveryStreamName(kinesisProp.getDeliveryStreamName());
		Record record = new Record();
		record.setData(ByteBuffer.wrap(message.getBytes()));
		putRecordRequest.setRecord(record);
		PutRecordResult result = kinesisClient.putRecord(putRecordRequest);
		logger.info(result.toString());
	}

}
