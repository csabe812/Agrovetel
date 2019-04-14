package com.agrovetel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Manufacturer;
import com.agrovetel.repository.ManufacturerRepository;

@Service
public class ManufacturerService {
	
	@Autowired
	private ManufacturerRepository manufacturerRepositoy;

	public List<Manufacturer> findAll() {
		return this.manufacturerRepositoy.findAll();
	}
	
	public Manufacturer findById(long id) {
		return this.manufacturerRepositoy.findById(id);
	}
	
}
