package com.agrovetel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Manufacturer;
import com.agrovetel.repository.ManufacturerRepository;

/**
 * A service class for finding manufacturer(s)
 * 
 * @author csabe812
 *
 */
@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepositoy;

	/**
	 * Finding all the manufacturers
	 * 
	 * @return
	 */
	public List<Manufacturer> findAll() {
		return this.manufacturerRepositoy.findAll();
	}

	/**
	 * Finding a manufacturer by its id
	 * 
	 * @param id
	 * @return
	 */
	public Manufacturer findById(long id) {
		return this.manufacturerRepositoy.findById(id);
	}

}
