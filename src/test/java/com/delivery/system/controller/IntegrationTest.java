package com.delivery.system.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.delivery.system.entity.ParcelDetails;

@SpringBootTest
public class IntegrationTest 
{
	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

//	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
	@Test
	public void testGetAgentDetails() 
	{
		assertTrue(
				this.restTemplate
				.getForObject("http://localhost:" + port + "/api/parcels?agentId=2", ParcelDetails[].class)
				.length == 2);
	}

	@Test
	public void testAddParcel() {
		ParcelDetails entry = new ParcelDetails(500,"Iman","",(double)20,"","","","",3);
		ResponseEntity<ParcelDetails> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/addParcelDetails", entry, ParcelDetails.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
}
