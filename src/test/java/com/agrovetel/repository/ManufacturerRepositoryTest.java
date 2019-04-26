package com.agrovetel.repository;

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
public class ManufacturerRepositoryTest {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Test
	public void testFindAllManufacturers() {
		List<Manufacturer> manufacturers = manufacturerRepository.findAll();
		assertNotNull(manufacturers);
		assertTrue(!manufacturers.isEmpty());
		assert (manufacturers.size() == 5);
	}

	@Test
	public void testById1() {
		Manufacturer manufacturer = manufacturerRepository.findById(1);
		assert (manufacturer.getManufacturerName().equals("MTZ"));
	}

	@Test
	public void testById4() {
		Manufacturer manufacturer = manufacturerRepository.findById(5);
		assert (manufacturer.getManufacturerName().equals("Yto"));
	}

}
