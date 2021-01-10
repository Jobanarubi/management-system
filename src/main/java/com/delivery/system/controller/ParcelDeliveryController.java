package com.delivery.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.system.entity.ParcelDetails;
import com.delivery.system.entity.User;
import com.delivery.system.exception.ResourceNotFoundException;
import com.delivery.system.service.ParcelDeliveryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class ParcelDeliveryController {

	@Autowired
	ParcelDeliveryService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(value="/addParcelDetails")
	public ResponseEntity<ParcelDetails> addDetails(@RequestBody ParcelDetails parcelDetails) throws ResourceNotFoundException{
		ParcelDetails addDetails = service.addDetails(parcelDetails);
		return ResponseEntity.ok(addDetails);
	}
	
	  @GetMapping(value="/parcels/status")
	  public ResponseEntity<ParcelDetails> getDetailsById(@RequestParam int consignmentId) throws ResourceNotFoundException{
		  Optional<ParcelDetails> detail = service.getDetailsById(consignmentId);
		  if(detail.isPresent()) {
			  return ResponseEntity.ok(detail.get());
		  }else {
			  throw new ResourceNotFoundException("Data not found");
		  }
	  }
	  
	  @GetMapping(value="/parcels")
	  public ResponseEntity<List<ParcelDetails>> getAgentDetails(@RequestParam String userName) throws ResourceNotFoundException{
		  User user = service.getUser(userName);
		  List<ParcelDetails> detail = service.getAgentDetails(user.getSeqid());
		  if(detail == null) {
			  throw new ResourceNotFoundException("Data not found");
		  }
		 return ResponseEntity.ok(detail);
	  }
	  
	  @PutMapping(value="/status")
	  public ResponseEntity<ParcelDetails> updateStatus(@RequestBody ParcelDetails parcelDetails) throws ResourceNotFoundException{
		  ParcelDetails updatedDetails = service.updateStatus(parcelDetails);
		  return ResponseEntity.ok(updatedDetails);
	  }
}
