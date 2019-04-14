package com.agrovetel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agrovetel.domain.Manufacturer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManufacturerServiceTest {

	@Autowired
	private ManufacturerService manufacturerService;
	
	@Test
	public void testFindAll() {
		List<Manufacturer> manufacturers = manufacturerService.findAll();
		assertNotNull(manufacturers);
		assertTrue(!manufacturers.isEmpty());
		assert(manufacturers.size()==5);			
	}
	
	@Test
	public void testFindById2() {
		Manufacturer manufacturer = manufacturerService.findById(2);
		assert(manufacturer.getManufacturerName().equals("Zetor"));
	}
	
	@Test
	public void testFindById3() {
		Manufacturer manufacturer = manufacturerService.findById(3);
		assert(manufacturer.getManufacturerName().equals("John Deere"));
	}

	
}
