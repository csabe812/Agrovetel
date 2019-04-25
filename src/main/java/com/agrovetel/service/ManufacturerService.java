package com.agrovetel.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Manufacturer;
import com.agrovetel.repository.ManufacturerRepository;
import com.agrovetel.service.exception.CategoryAlreadyExistsException;
import com.agrovetel.service.exception.ManufacturerAlreadyExistsException;

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
	 * Create a manufacturer
	 * 
	 * @param manufacturerName
	 * @return
	 */
	public Manufacturer createManufacturerByManufacturerName(String manufacturerName)
			throws ManufacturerAlreadyExistsException {
		if (manufacturerAlreadyExists(manufacturerName) == false) {
			Manufacturer manufacturer = new Manufacturer(manufacturerName);
			return this.manufacturerRepositoy.save(manufacturer);
		} else {
			throw new ManufacturerAlreadyExistsException("The " + manufacturerName + " manufacturer already exists.");
		}
	}

	/**
	 * Update a manufacturer
	 * 
	 * @param id
	 * @param updatedManufacturer
	 */
	public void updateManufacturer(long id, Manufacturer updatedManufacturer)
			throws ManufacturerAlreadyExistsException {
		Manufacturer manufacturer = this.manufacturerRepositoy.findById(id);
		log.info("" + updatedManufacturer.getManufacturerName());
		if (manufacturerAlreadyExists(updatedManufacturer.getManufacturerName()) == false) {
			manufacturer.setManufacturerName(updatedManufacturer.getManufacturerName());
			this.manufacturerRepositoy.save(manufacturer);
		} else {
			throw new ManufacturerAlreadyExistsException(
					"The " + updatedManufacturer.getManufacturerName() + " manufacturer already exists.");
		}
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

	public boolean manufacturerAlreadyExists(String manufacturerName) {
		manufacturerName = manufacturerName.toLowerCase();
		List<Manufacturer> manufacturers = manufacturerRepositoy.findAll();
		for (Manufacturer manufacturer : manufacturers) {
			if (manufacturer.getManufacturerName().toLowerCase().equals(manufacturerName)) {
				return true;
			}
		}
		return false;
	}

}
