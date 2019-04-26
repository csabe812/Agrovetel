package com.agrovetel.repository;

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
public class AdRepositoryTest {

	@Autowired
	private AdRepository adRepository;

	@Test
	public void testFindAllAds() {
		List<Ad> ads = (List<Ad>) adRepository.findAll();
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
	}

	@Test
	public void testFindAdById1() {
		Ad ad = adRepository.findById((long) 1);
		assertNotNull(ad);
	}

	@Test
	public void testFindAdById2() {
		Ad ad = adRepository.findById((long) 1);
		assert (ad.getTitle().equals("Ad1"));
		assert (ad.getPrice() == 20);
		assert (ad.getHorsePower() == 150);
		assert (ad.getYearOfManufact() == 1980);

	}

	/**
	 * Created 3 testdata to the county (id = 1) so 3 ads need to be returned
	 */
	@Test
	public void testFindAllByCountyId() {
		List<Ad> ad = this.adRepository.findAllByCountyId(1);
		assert (ad.size() == 3);
	}

}
