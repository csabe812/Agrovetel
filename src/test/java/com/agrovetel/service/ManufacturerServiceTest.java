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
import com.agrovetel.service.exception.ManufacturerAlreadyExistsException;

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
	
	@Test
	public void testDisableManufacturerById4() {
		manufacturerService.disableManufacturerById(4);;
		assert(manufacturerService.findById(4).isEnabled() == false);
	}
	
	@Test
	public void testEnableManufacturerById3() {
		manufacturerService.enableManufacturerById(3);;
		assert(manufacturerService.findById(3).isEnabled() == true);
	}
	
	@Test
	public void testCategoryAlreadyExists() {
		assert(manufacturerService.manufacturerAlreadyExists("ZEtor") == true);
		assert(manufacturerService.manufacturerAlreadyExists("ZETOR") == true);
		assert(manufacturerService.manufacturerAlreadyExists("MTZ") == true);
		assert(manufacturerService.manufacturerAlreadyExists("mtz") == true);
		assert(manufacturerService.manufacturerAlreadyExists("john deere") == true);
		assert(manufacturerService.manufacturerAlreadyExists("new hOlland") == true);
		assert(manufacturerService.manufacturerAlreadyExists("yTO") == true);
		assert(manufacturerService.manufacturerAlreadyExists("Valami") == false);
	}
	
	@Test(expected = ManufacturerAlreadyExistsException.class)
	public void testCreateManufacturerByManufacturerNameThrowsManufacturerAlreadyExistsException() throws ManufacturerAlreadyExistsException {
		manufacturerService.createManufacturerByManufacturerName("Zetor");
	}
	
	@Test(expected = ManufacturerAlreadyExistsException.class)
	public void testUpdateManufacturerThrowsCategoryAlreadyExistsException() throws ManufacturerAlreadyExistsException {
		Manufacturer updatedManufacturer = new Manufacturer("YTO");
		manufacturerService.updateManufacturer(2, updatedManufacturer);
	}

	
}
