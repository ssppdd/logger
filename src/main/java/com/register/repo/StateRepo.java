package com.register.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.StateEntity;

public interface StateRepo extends JpaRepository<StateEntity, Integer> {
	
	public List findAllByCountryId(Integer countryId);

}
