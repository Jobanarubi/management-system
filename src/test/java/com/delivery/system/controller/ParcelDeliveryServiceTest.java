package com.delivery.system.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.delivery.system.entity.ParcelDetails;
import com.delivery.system.repository.ParcelDeliveryRepository;

@WebMvcTest
public class ParcelDeliveryServiceTest {

	@TestConfiguration
	static class ParcelDeliveryService{
		@Bean
		public ParcelDeliveryService parcelDeliveryService() {
			return new ParcelDeliveryService();
		}
	}
	
	@Autowired
	private ParcelDeliveryService service;
	
	@MockBean
	private ParcelDeliveryRepository repo;
	
	@Test
	void testUpdateStatus() throws Exception{
		ParcelDetails parcel = new ParcelDetails();
        parcel.setConsignmentId(100);
        parcel.setSeqid(2);
        parcel.setStatus("Transit");
		Mockito.when(repo.save(parcel)).thenReturn(parcel);
	}
}
