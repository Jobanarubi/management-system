package com.delivery.system.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.delivery.system.entity.ParcelDetails;
import com.delivery.system.repository.ParcelDeliveryRepository;
import com.delivery.system.service.ParcelDeliveryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ParcelDeliveryControllerTest {
	
	    @Autowired
	    private MockMvc mockMvc;
	 
	    @MockBean
	    private ParcelDeliveryService deliveryService;
	    
	    @MockBean
	    private ParcelDeliveryRepository repository;
	    
	    @Test
	    public void testUpdateDetailsService() throws Exception {
	        ParcelDetails parcel = new ParcelDetails();
	        parcel.setConsignmentId(100);
	        parcel.setSeqid(2);
	        parcel.setStatus("Transit");
	        Optional<ParcelDetails> obj=Optional.of(parcel);
	        Mockito.when(repository.findById(parcel.getConsignmentId())).thenReturn(obj);
	        assertEquals(100, parcel.getConsignmentId());
	    }
	 
	    private static ObjectMapper mapper = new ObjectMapper();
	 
	    @Test
	    public void testGetAgentDetails() throws Exception {
	        List<ParcelDetails> parcels = new ArrayList<>();
	        ParcelDetails parcel = new ParcelDetails();
	        parcel.setConsignmentId(100);
	        parcel.setSeqid(2);
	        parcels.add(parcel);
	        Mockito.when(deliveryService.getAgentDetails(parcel.getSeqid())).thenReturn(parcels);
	        mockMvc.perform(get("/api/parcels?agentId=2")).andExpect(status().isOk());
	    }
	    
	    @Test
	    public void testGetDetailsById() throws Exception {
	        ParcelDetails parcel = new ParcelDetails();
	        parcel.setConsignmentId(100);
	        parcel.setSeqid(2);
	        Optional<ParcelDetails> obj=Optional.of(parcel);
	        Mockito.when(deliveryService.getDetailsById(parcel.getConsignmentId())).thenReturn(obj);
	        mockMvc.perform(get("/api/parcels/status?consignmentId=100")).andExpect(status().isOk());
	    }
	 
	    @Test
	    public void testAddDetails() throws Exception {
	    	ParcelDetails parcel = new ParcelDetails();
	    	parcel.setConsignmentId(300);
	        parcel.setSeqid(2);
	        parcel.setDeliveryAddress("Trichy");
	        parcel.setDeliveryAgent("DTC");
	        parcel.setParcelDetails("Fully packed");
	        parcel.setStatus("Transit");
	        parcel.setWeight((double) 30);
	        parcel.setPackagingType("F");
	        Mockito.when(deliveryService.addDetails(ArgumentMatchers.any())).thenReturn(parcel);
	        String json = mapper.writeValueAsString(parcel);
	        mockMvc.perform(post("/api/addParcelDetails").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	        		.andExpect(jsonPath("$.seqid").value(2));
	    }
	 
	    @Test
	    public void testUpdateStatus() throws Exception {
	    	ParcelDetails parcel = new ParcelDetails();
	    	parcel.setConsignmentId(300);
	        parcel.setSeqid(2);
	        parcel.setDeliveryAddress("Trichy");
	        Mockito.when(deliveryService.updateStatus(ArgumentMatchers.any())).thenReturn(parcel);
	        String json = mapper.writeValueAsString(parcel);
	        mockMvc.perform(put("/api/status").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	        		.andExpect(jsonPath("$.seqid").value(2));
	    }
	 
}
