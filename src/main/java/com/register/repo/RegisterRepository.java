package com.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.domain.Register;
import com.register.entity.RegisterEntity;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
	
	public RegisterEntity findByEmail(String email);
	
	

}
