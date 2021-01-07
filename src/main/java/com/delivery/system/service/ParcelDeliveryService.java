package com.delivery.system.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.delivery.system.entity.ParcelDetails;
import com.delivery.system.entity.User;
import com.delivery.system.exception.ResourceNotFoundException;
import com.delivery.system.repository.ParcelDeliveryRepository;
import com.delivery.system.repository.UserRepository;

@Service
@Transactional
public class ParcelDeliveryService {
	
	@Autowired
	ParcelDeliveryRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	public ParcelDetails addDetails(ParcelDetails parcelDetails) {
		return repository.save(parcelDetails);
	}
	
	public ParcelDetails updateStatus(ParcelDetails parcelDetails) throws ResourceNotFoundException {
		Optional<ParcelDetails> details = repository.findById(parcelDetails.getConsignmentId());
		if(details.isPresent()) {
			ParcelDetails entry = details.get();
			entry.setStatus(parcelDetails.getStatus());
			repository.save(entry);
			return entry;
		}else {
			throw new ResourceNotFoundException("Data not found");
		}
	}
	
	public Optional<ParcelDetails> getDetailsById(int parcelId) {
		Optional<ParcelDetails> parcelDetail = repository.findById(parcelId);
		return parcelDetail;
	}
	
	public List<ParcelDetails> getAgentDetails(int seqid) {
		List<ParcelDetails> parcelDetail = repository.findBySeqid(seqid);
		return parcelDetail;
	}
	
	public User getUser(String userName) {
		return userRepository.findByUsername(userName);
	}
	
}
