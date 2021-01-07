package com.delivery.system.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.delivery.system.entity.ParcelDetails;
import com.delivery.system.entity.User;
import com.delivery.system.service.ParcelDeliveryService;

@WebMvcTest
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ParcelDeliveryService service;

	@Test
	public void testLogin() throws Exception {
		User user = new User();
		user.setPassword("aaa");
		user.setUsername("aaa");
		user.setSeqid(10);
		Mockito.when(service.getUser(user.getUsername())).thenReturn(user);
		mockMvc.perform(get("/login")).andExpect(status().isOk());
	}
}
