package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agrovetel.domain.County;

public interface CountyRepository extends CrudRepository<County, Long> {
	
	County findById(long id);
	List<County> findAll();
	void deleteById(long id);

}
