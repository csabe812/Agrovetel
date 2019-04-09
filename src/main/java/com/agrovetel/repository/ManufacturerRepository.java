package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Category;
import com.agrovetel.domain.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

	Manufacturer findById(long id);
	List<Manufacturer> findAll();
}
