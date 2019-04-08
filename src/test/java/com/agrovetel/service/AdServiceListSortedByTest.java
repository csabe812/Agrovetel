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
	public void testFindAllAdByCategory1() {
		List<Ad> ads = adService.findByCategory(1);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==3);
		assert(ads.get(1).getPrice()==25);
	}
	
	@Test
	public void testFindAllAdByCategory2() {
		List<Ad> ads = adService.findByCategory(2);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==1);
		assert(ads.get(0).getYearOfManufact()==2019);
	}
	
	@Test
	public void testFindAllAdByCategory3() {
		List<Ad> ads = adService.findByCategory(3);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==1);
		assert(ads.get(0).getHorsePower()==1150);
	}

	@Test
	public void testFindAllAdByUser1() {
		List<Ad> ads = adService.findByUser(1);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==1);
		assert(ads.get(0).getYearOfManufact() == 1980);
	}
	
	@Test
	public void testFindAllAdByUser2() {
		List<Ad> ads = adService.findByUser(2);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==2);
		assert(ads.get(1).getPrice()== 35);
	}
	
	@Test
	public void testFindAllAdByUser3() {
		List<Ad> ads = adService.findByUser(3);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert(ads.size()==2);
		assert(ads.get(1).getCategory().getId()==3);
	}
	
}
