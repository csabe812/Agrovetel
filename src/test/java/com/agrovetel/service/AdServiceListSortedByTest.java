package com.agrovetel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;
import com.agrovetel.domain.Manufacturer;
import com.agrovetel.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdServiceListSortedByTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdService adService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ManufacturerService manufacturerService;

	@Autowired
	private UserService userService;

	@Test
	public void createNewAdTest() {
		Category category = categoryService.findCategoryById(1);
		Manufacturer manufacturer = manufacturerService.findById(1);
		User user = userService.findById(1);
		Ad ad = new Ad("Valami", 25.00, "Valami leírás", LocalDateTime.now(), true, 150, 2018, category, manufacturer,
				user, 0);
		adService.updateCreateAd(ad);
		List<Ad> ads = adService.findAll();
		assert (ads.size() == 6);
		assert (ad.getDescription().equals("Valami leírás"));
		assert (ad.getHorsePower() == 150);
		assert (ad.getManufacturer().getId() == 1);
		assert (ad.getNumberOfVisitors() == 0);
		assert (ad.getPrice() == 25);
		assert (ad.isSellOrSearch() == true);
		log.info("" + ad.getTimeStamp());
		assert (ad.getTitle().equals("Valami"));
		assert (ad.getYearOfManufact() == 2018);
		assert (ad.getUser().getFullname().equals("admin"));
		assert (ad.getCategory().getId() == 1);
	}

	@Test
	public void updateAdTest() {
		Ad ad = adService.findById(1);
		ad.setDescription("Most változtatom meg");
		ad.setHorsePower(200);
		ad.setManufacturer(manufacturerService.findById(5));
		ad.setNumberOfVisitors(100);
		ad.setPrice(500.25);
		ad.setSellOrSearch(false);
		ad.setTimeStamp(LocalDateTime.of(2019, 4, 25, 12, 48));
		ad.setTitle("Új cím");
		ad.setUser(userService.findById(3));
		ad.setYearOfManufact(2000);
		ad.setCategory(categoryService.findCategoryById(4));
		adService.updateCreateAd(ad);
		assert (ad.getDescription().equals("Most változtatom meg"));
		assert (ad.getHorsePower() == 200);
		assert (ad.getManufacturer().getId() == 5);
		assert (ad.getNumberOfVisitors() == 100);
		assert (ad.getPrice() == 500.25);
		assert (ad.isSellOrSearch() == false);
		log.info("" + ad.getTimeStamp());
		assert (ad.getTitle().equals("Új cím"));
		assert (ad.getYearOfManufact() == 2000);
		assert (ad.getUser().getFullname().equals("JaneDoe"));
		assert (ad.getCategory().getId() == 4);
	}

	@Test
	public void testFindAllAdByCategory1() {
		List<Ad> ads = adService.findByCategory(1);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert (ads.size() == 2);
		assert (ads.get(1).getPrice() == 35);
	}

	@Test
	public void testFindAllAdByCategory2() {
		List<Ad> ads = adService.findByCategory(2);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert (ads.size() == 1);
		assert (ads.get(0).getYearOfManufact() == 2019);
	}

	@Test
	public void testFindAllAdByCategory3() {
		List<Ad> ads = adService.findByCategory(3);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert (ads.size() == 1);
		assert (ads.get(0).getHorsePower() == 1150);
	}

	@Test
	public void testFindAllAdByUser1() {
		List<Ad> ads = adService.findAllByUser(1);
		assertTrue(!ads.isEmpty());
		assert (ads.size() == 1);
		assert (ads.get(0).getYearOfManufact() == 1980);
	}

	@Test
	public void testFindAllAdByUser2() {
		List<Ad> ads = adService.findAllByUser(2);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert (ads.size() == 1);
		assert (ads.get(0).getPrice() == 35);
	}

	@Test
	public void testFindAllAdByUser3() {
		List<Ad> ads = adService.findAllByUser(3);
		assertNotNull(ads);
		assertTrue(!ads.isEmpty());
		assert (ads.size() == 3);
		assert (ads.get(1).getCategory().getId() == 2);
	}

	@Test
	public void testDisabledById3() {
		adService.disableById(3);
		Ad ad = adService.findById(3);
		assert (ad.isEnabled() == false);
	}

	@Test
	public void testEnabledById5() {
		adService.enableById(5);
		Ad ad = adService.findById(5);
		assert (ad.isEnabled() == true);
	}

	@Test
	public void testIncrementNumberOfVisitorsById4() {
		Ad ad = adService.incrementNumberOfVisitors(4);
		assert (ad.getNumberOfVisitors() == 13);
	}

}
