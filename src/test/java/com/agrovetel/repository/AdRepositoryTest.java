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
		List<Ad> ads = this.adRepository.findAllByCountyId(1);
		assert (ads.size() == 3);
	}
	
	@Test
	public void testFindByPriceBetweenOrderByPriceAsc() {
		List<Ad> ads = this.adRepository.findByPriceBetweenOrderByPriceAsc(20, 35);
		assert(ads.size() == 5);
		assert(ads.get(0).getTitle().equals("Ad1"));
	}
	
	@Test
	public void testFindByPriceBetweenOrderByPriceDesc() {
		List<Ad> ads = this.adRepository.findByPriceBetweenOrderByPriceDesc(25, 35);
		assert(ads.size() == 4);
		assert(ads.get(0).getTitle().equals("Ad3"));
	}
	
	@Test
	public void testFindByPriceGreaterThanOrderByPriceAsc() {
		List<Ad> ads = this.adRepository.findByPriceGreaterThanOrderByPriceAsc(34);
		assert(ads.size() == 3);
		assert(ads.get(0).getTitle().equals("Ad3"));
	}
	
	@Test
	public void testFindByPriceGreaterThanOrderByPriceDesc() {
		List<Ad> ads = this.adRepository.findByPriceGreaterThanOrderByPriceDesc(34);
		assert(ads.size() == 3);
		assert(ads.get(0).getTitle().equals("Ad5"));
	}
	
	@Test
	public void testFindByPriceLessThanOrderByPriceAsc() {
		List<Ad> ads = this.adRepository.findByPriceLessThanOrderByPriceAsc(34);
		assert(ads.size() == 3);
		assert(ads.get(0).getTitle().equals("Ad1"));
	}
	
	@Test
	public void testFindByPriceLessThanOrderByPriceDesc() {
		List<Ad> ads = this.adRepository.findByPriceLessThanOrderByPriceDesc(34);
		assert(ads.size() == 3);
		assert(ads.get(0).getTitle().equals("Ad4"));
	}
	
	@Test
	public void testFindByNumberOfVisitorsBetweenOrderByNumberOfVisitorsDesc() {
		List<Ad> ads = this.adRepository.findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsDesc(5,12);
		assert(ads.size() == 2);
		assert(ads.get(0).getTitle().equals("Ad4"));
	}
	
	@Test
	public void testFindByNumberOfVisitorsBetweenOrderByNumberOfVisitorsAsc() {
		List<Ad> ads = this.adRepository.findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsAsc(5,12);
		assert(ads.size() == 2);
		assert(ads.get(0).getTitle().equals("Ad3"));
	}
	
	@Test
	public void testFindByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsAsc() {
		List<Ad> ads = this.adRepository.findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsAsc(4);
		assert(ads.size() == 2);
		assert(ads.get(0).getTitle().equals("Ad3"));
	}
	
	@Test
	public void testFindByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsDesc() {
		List<Ad> ads = this.adRepository.findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsDesc(4);
		assert(ads.size() == 2);
		assert(ads.get(0).getTitle().equals("Ad4"));
	}

	@Test
	public void testFindByNumberOfVisitorsLessThanOrderByNumberOfVisitorsAsc() {
		List<Ad> ads = this.adRepository.findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsAsc(6);
		assert(ads.size() == 5);
		assert(ads.get(2).getTitle().equals("Ad6"));
	}
	
	@Test
	public void testFindByNumberOfVisitorsLessThanOrderByNumberOfVisitorsDesc() {
		List<Ad> ads = this.adRepository.findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsDesc(6);
		assert(ads.size() == 5);
		System.out.println(ads.get(0).getTitle());
		assert(ads.get(0).getTitle().equals("Ad3"));
	}
	
	@Test
	public void testFindBySellSearchTrue() {
		List<Ad> ads = this.adRepository.findBySellSearchTrue();
		assert(ads.size() == 5);
	}
	
	@Test
	public void testFindBySellSearchFalse() {
		List<Ad> ads = this.adRepository.findBySellSearchFalse();
		assert(ads.size() == 1);
	}


}
