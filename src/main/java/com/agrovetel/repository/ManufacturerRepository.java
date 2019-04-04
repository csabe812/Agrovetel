package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

}
