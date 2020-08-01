package com.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Integer> {

}
