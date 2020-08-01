package com.register.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Integer> {
	
	public List findAllByStateId(Integer stateId);

}
