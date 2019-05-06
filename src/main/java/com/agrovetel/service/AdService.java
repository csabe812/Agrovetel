package com.agrovetel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Ad;
import com.agrovetel.repository.AdRepository;

/**
 * A service class for finding ad(s)
 * 
 * @author kafr007
 *
 */
@Service
public class AdService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private AdRepository adRepository;

	/**
	 * Setter-base autowiring
	 * 
	 * @param adRepository
	 */
	@Autowired
	public void setAdRepository(AdRepository adRepository) {
		this.adRepository = adRepository;
	}

	private UserService userService;

	/**
	 * Setter-based autowiring
	 * 
	 * @param userService
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Finding all the ads
	 * 
	 * @return
	 */
	public List<Ad> findAll() {
		return this.adRepository.findAll();
	}

	/**
	 * Finding all the ads by userId
	 * 
	 * @param userId a user's id
	 * @return all the user's ads
	 */
	public List<Ad> findAllByUser(long userId) {
		return this.adRepository.findAllByUserId(userId);
	}
	
	/**
	 * Finding all the ads by userId and enabled boolean
	 * @param userId
	 * @param enabled
	 * @return
	 */
	public List<Ad> findAllByUserIdAndEnabled(long userId, boolean enabled) {
		return this.adRepository.findAllByUserIdAndEnabled(userId, enabled);
	}

	/**
	 * Finding all the ads by category id
	 * 
	 * @param categoryId a category's id
	 * @return all the category's ads
	 */
	public List<Ad> findByCategory(long categoryId) {
		return this.adRepository.findByCategoryId(categoryId);
	}

	/**
	 * Finding an ad by its id
	 * 
	 * @param id The id of the ad
	 * @return
	 */
	public Ad findById(long id) {
		incrementNumberOfVisitors(id);
		return adRepository.findById(id);
	}

	public List<Ad> findAllByCategoryId(long id) {
		return this.adRepository.findAllByCategoryId(id);
	}

	/**
	 * Incrementing the number of the visitors
	 * 
	 * @param id the id of the ad need to be incremented
	 * @return the incremented ad
	 */
	public Ad incrementNumberOfVisitors(long id) {
		Ad ad = adRepository.findById(id);
		int numberOfVisitors = ad.getNumberOfVisitors();
		numberOfVisitors++;
		ad.setNumberOfVisitors(numberOfVisitors);
		adRepository.save(ad);
		return ad;
	}

	/**
	 * Find all ads by county id
	 * 
	 * @param id county_id
	 * @return the list of the ads
	 */
	public List<Ad> findAllByCountyId(long id) {
		return this.adRepository.findAllByCountyId(id);
	}

	/**
	 * Deleting an ad by its id
	 * 
	 * @param id
	 */
	public void deleteAdById(long id) {
		this.adRepository.deleteById(id);
	}

	/**
	 * Updating an ad by its id
	 * 
	 * @param ad
	 * @return
	 */
	public Ad updateCreateAd(Ad ad) {
		return this.adRepository.save(ad);
	}

	/**
	 * Updates an ad
	 * 
	 * @param updatedAd
	 */
	public void updateAd(long id, Ad updatedAd) {
		log.info("this iz the id: " + updatedAd.toString());
		Ad ad = this.adRepository.findById(id);
		if(ad == null) {
			log.info("Ad was not found, it is null");
			ad = new Ad();
			ad.setTitle(updatedAd.getTitle());
			ad.setDescription(updatedAd.getDescription());
			ad.setHorsePower(updatedAd.getHorsePower());
			ad.setPrice(updatedAd.getPrice());
			ad.setYearOfManufact(updatedAd.getYearOfManufact());
			ad.setEnabled(true);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			ad.setUser(this.userService.findByEmail(auth.getName()));
			log.info("Given ad will be saved: " + ad.toString());
			this.adRepository.save(ad);
		}
		else {
			log.info("Ad which will be updated: " + ad.toString());
			log.info("Updated with: " + updatedAd.toString());
			ad.setSellOrSearch(updatedAd.isSellOrSearch());
			ad.setTitle(updatedAd.getTitle());
			ad.setDescription(updatedAd.getDescription());
			ad.setManufacturer(updatedAd.getManufacturer());
			ad.setCategory(updatedAd.getCategory());
			ad.setYearOfManufact(updatedAd.getYearOfManufact());
			ad.setHorsePower(updatedAd.getHorsePower());
			ad.setPrice(updatedAd.getPrice()); //ad.setCounty(updatedAd.getCounty());
			ad.setTimeStamp(updatedAd.getTimeStamp());
			this.adRepository.save(ad);
		}
	}

	/**
	 * Disable an ad by its id
	 * 
	 * @param id
	 */
	public void disableById(long id) {
		Ad ad = this.adRepository.findById(id);
		ad.setEnabled(false);
		this.adRepository.save(ad);
	}

	/**
	 * Enable an ad by its id
	 * 
	 * @param id
	 */
	public void enableById(long id) {
		Ad ad = this.adRepository.findById(id);
		ad.setEnabled(true);
		this.adRepository.save(ad);
	}
	
	/**
	 * Find all ads by price between order by price asc
	 * 
	 * @param double bottomPrice
	 * @param double topPrice
	 * @return the list of the ads
	 */
	public List<Ad> findByPriceBetweenOrderByPriceAsc(double bottomPrice, double topPrice){
		return this.adRepository.findByPriceBetweenOrderByPriceAsc(bottomPrice, topPrice);
	}
	
	/**
	 * Find all ads by price between two prices and order by price desc
	 * 
	 * @param double bottomPrice
	 * @param double topPrice
	 * @return the list of the ads
	 */
	public List<Ad> findByPriceBetweenOrderByPriceDesc(double bottomPrice, double topPrice){
		return this.adRepository.findByPriceBetweenOrderByPriceDesc(bottomPrice, topPrice);
	}
	
	/**
	 * Find all ads by price greater than and order by price asc
	 * 
	 * @param double bottomPrice
	 * @return the list of the ads
	 */
	public List<Ad> findByPriceGreaterThanOrderByPriceAsc(double bottomPrice){
		return this.adRepository.findByPriceGreaterThanOrderByPriceAsc(bottomPrice);
	}
	
	/**
	 * Find all ads by price greater than and order by price desc
	 * 
	 * @param double topPrice
	 * @return the list of the ads
	 */
	public List<Ad> findByPriceGreaterThanOrderByPriceDesc(double topPrice){
		return this.adRepository.findByPriceGreaterThanOrderByPriceDesc(topPrice);
	}
	
	/**
	 * Find all ads by price less than and order by price asc
	 * 
	 * @param double topPrice
	 * @return the list of the ads
	 */
	public List<Ad> findByPriceLessThanOrderByPriceAsc(double topPrice){
		return this.adRepository.findByPriceLessThanOrderByPriceAsc(topPrice);
	}
	
	/**
	 * Find all ads by price less than and order by price desc
	 * 
	 * @param double bottomPrice
	 * @return the list of the ads
	 */
	public List<Ad> findByPriceLessThanOrderByPriceDesc(double bottomPrice){
		return this.adRepository.findByPriceLessThanOrderByPriceDesc(bottomPrice);
	}
	
	/**
	 * Find all ads by number of visitors between order by number of visitors asc
	 * 
	 * @param double bottomNumberOfVisitors
	 * @param double topNumberOfVisitors
	 * @return the list of the ads
	 */
	public List<Ad> findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsAsc(int bottomNumberOfVisitors, int topNumberOfVisitors){
		return this.adRepository.findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsAsc(bottomNumberOfVisitors, topNumberOfVisitors);
	}
	
	/**
	 * Find all ads by number of visitors between two prices and order by number of visitors desc
	 * 
	 * @param double bottomNumberOfVisitors
	 * @param double topNumberOfVisitors
	 * @return the list of the ads
	 */
	public List<Ad> findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsDesc(int bottomNumberOfVisitors, int topNumberOfVisitors){
		return this.adRepository.findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsDesc(bottomNumberOfVisitors, topNumberOfVisitors);
	}
	
	/**
	 * Find all ads by number of visitors greater than number of visitor and order by number of visitors asc
	 * 
	 * @param double bottomNumberOfVisitors
	 * @return the list of the ads
	 */
	public List<Ad> findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsAsc(int bottomNumberOfVisitors){
		return this.adRepository.findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsAsc(bottomNumberOfVisitors);
	}
	
	/**
	 * Find all ads by number of visitors greater than number of visitor and order by number of visitors desc
	 * 
	 * @param double bottomNumberOfVisitors
	 * @return the list of the ads
	 */
	public List<Ad> findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsDesc(int bottomNumberOfVisitors){
		return this.adRepository.findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsDesc(bottomNumberOfVisitors);
	}
	
	/**
	 * Find all ads by number of visitors less than number of visitor and order by number of visitors asc
	 * 
	 * @param double topNumberOfVisitors
	 * @return the list of the ads
	 */
	public List<Ad> findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsAsc(int topNumberOfVisitors){
		return this.adRepository.findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsAsc(topNumberOfVisitors);
	}
	
	/**
	 * Find all ads by number of visitors less than number of visitor and order by number of visitors desc
	 * 
	 * @param double topNumberOfVisitors
	 * @return the list of the ads
	 */
	public List<Ad> findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsDesc(int topNumberOfVisitors){
		return this.adRepository.findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsDesc(topNumberOfVisitors);
	}
	
	/**
	 * Find all ads by sell 
	 * 
	 * @return the list of the ads
	 */
	public List<Ad> findBySellSearchTrue(){
		return this.adRepository.findBySellSearchTrue();
	}
	
	/**
	 * Find all ads by search 
	 * 
	 * @return the list of the ads
	 */
	public List<Ad> findBySellSearchFalse(){
		return this.adRepository.findBySellSearchFalse();
	}
	
	
}
