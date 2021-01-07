package com.delivery.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.system.entity.ParcelDetails;

@Repository
public interface ParcelDeliveryRepository extends JpaRepository<ParcelDetails, Integer>{
		 List<ParcelDetails> findBySeqid(int seqid);
}
