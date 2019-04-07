package com.agrovetel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agrovetel.domain.Ad;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdServiceListSortedByTest {

	@Autowired
	private AdService adService;
	
	@Test
	public void testFindAllAdsByCategory1() {
		List<Ad> ads = (List<Ad>) adService.findAllByCategory(1);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==3);
		assert(ads.get(1).getPrice()==25);
	}
	
	@Test
	public void testFindAllAdsByCategory2() {
		List<Ad> ads = (List<Ad>) adService.findAllByCategory(2);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==1);
		assert(ads.get(0).getYearOfManufact()==2019);
	}
	
	@Test
	public void testFindAllAdsByCategory3() {
		List<Ad> ads = (List<Ad>) adService.findAllByCategory(3);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==1);
		assert(ads.get(0).getHorsePower()==1150);
	}

	@Test
	public void testFindAllAdsByUser1() {
		List<Ad> ads = (List<Ad>) adService.findAllByUser(1);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==1);
		assert(ads.get(0).getYearOfManufact() == 1980);
	}
	
	@Test
	public void testFindAllAdsByUser2() {
		List<Ad> ads = (List<Ad>) adService.findAllByUser(2);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==2);
		assert(ads.get(1).getPrice()== 35);
	}
	
	@Test
	public void testFindAllAdsByUser3() {
		List<Ad> ads = (List<Ad>) adService.findAllByUser(3);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==2);
		assert(ads.get(1).getCategory().getId()==3);
	}
	
}
