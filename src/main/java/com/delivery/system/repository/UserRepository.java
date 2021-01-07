package com.delivery.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
		 
	User findBySeqid(int seqid);
	
	User findByUsername(String username);
}
