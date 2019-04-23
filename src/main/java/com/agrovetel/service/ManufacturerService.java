package com.agrovetel.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Category;
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

	private final Logger log = LoggerFactory.getLogger(this.getClass());

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

	/**
	 * Update/save a manufacturer
	 * 
	 * @param manufacturer
	 * @return
	 */
	public Manufacturer updateCreateManufacturer(@Valid Manufacturer manufacturer) {
		return this.manufacturerRepositoy.save(manufacturer);
	}

	/**
	 * Update a manufacturer
	 * 
	 * @param id
	 * @param updatedManufacturer
	 */
	public void updateManufacturer(long id, Manufacturer updatedManufacturer) {
		Manufacturer manufacturer = this.manufacturerRepositoy.findById(id);
		log.info("" + updatedManufacturer.getManufacturerName());
		manufacturer.setManufacturerName(updatedManufacturer.getManufacturerName());
		this.manufacturerRepositoy.save(manufacturer);
	}

	/**
	 * Disabla a manufacturer
	 * 
	 * @param id
	 */
	public void disableManufacturerById(long id) {
		Manufacturer manufacturer = this.manufacturerRepositoy.findById(id);
		manufacturer.setEnabled(false);
		this.manufacturerRepositoy.save(manufacturer);
	}

	/**
	 * Enable a manufacturer
	 * 
	 * @param id
	 */
	public void enableManufacturerById(long id) {
		Manufacturer manufacturer = this.manufacturerRepositoy.findById(id);
		manufacturer.setEnabled(true);
		this.manufacturerRepositoy.save(manufacturer);
	}

}
