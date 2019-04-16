package com.agrovetel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Ad;
import com.agrovetel.repository.AdRepository;

/**
 * A service class for finding categori(es)
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
	public List<Ad> findByUser(long userId) {
		return this.adRepository.findByUserId(userId);
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
		log.info("Ad which will be updated: " + ad.toString());
		log.info("Updated with: " + updatedAd.toString());
		/*
		 * //ad.setSellOrSearch(updatedAd.isSellOrSearch());
		 * ad.setTitle(updatedAd.getTitle());
		 * ad.setDescription(updatedAd.getDescription());
		 * //ad.setManufacturer(updatedAd.getManufacturer());
		 * //ad.setCategory(updatedAd.getCategory());
		 * ad.setYearOfManufact(updatedAd.getYearOfManufact());
		 * ad.setHorsePower(updatedAd.getHorsePower());
		 * //ad.setPrice(updatedAd.getPrice()); //ad.setCounty(updatedAd.getCounty());
		 * //ad.setTimeStamp(updatedAd.getTimeStamp());
		 */
		// this.adRepository.save(ad);
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

}
