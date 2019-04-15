package com.agrovetel.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.User;
import com.agrovetel.repository.AdRepository;

@Service
public class AdService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdRepository adRepository;
	
	public List<Ad> findAll() {
		return this.adRepository.findAll();
	}
		
	public List<Ad> findByUser(long userId) {
		return this.adRepository.findByUserId(userId);
	}
	
	public List<Ad> findByCategory(long categoryId) {
		return this. adRepository.findByCategoryId(categoryId);
	}
	
	public Ad findById(long id) {
		incrementNumberOfVisitors(id);
		return adRepository.findById(id);
	}
	
	public List<Ad> findAllByCategoryId(long id){
		return this.adRepository.findAllByCategoryId(id);
	}
	
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
	 * @param id county_id
	 * @return the list of the ads
	 */
	public List<Ad> findAllByCountyId(long id) {
		return this.adRepository.findAllByCountyId(id);
	}
	
	public void deleteAdById(long id) {
		this.adRepository.deleteById(id);
	}
	
	public Ad updateCreateAd(Ad ad) {
		return this.adRepository.save(ad);
	}
	
	
	public AdRepository getAdRepository() {
		return adRepository;
	}

	public void setAdRepository(AdRepository adRepository) {
		this.adRepository = adRepository;
	}

	/**
	 * Updates an ad
	 * @param updatedAd
	 */
	public void updateAd(long id, Ad updatedAd) {
		log.info("this iz the id: " + updatedAd.toString());
		Ad ad = this.adRepository.findById(id);
		log.info("Ad which will be updated: " + ad.toString());
		log.info("Updated with: " + updatedAd.toString());
		/*//ad.setSellOrSearch(updatedAd.isSellOrSearch());
		ad.setTitle(updatedAd.getTitle());
		ad.setDescription(updatedAd.getDescription());
		//ad.setManufacturer(updatedAd.getManufacturer());
		//ad.setCategory(updatedAd.getCategory());
		ad.setYearOfManufact(updatedAd.getYearOfManufact());
		ad.setHorsePower(updatedAd.getHorsePower());
		//ad.setPrice(updatedAd.getPrice());
		//ad.setCounty(updatedAd.getCounty());
		//ad.setTimeStamp(updatedAd.getTimeStamp());*/
		//this.adRepository.save(ad);
	}

	public void disableById(long id) {
		Ad ad = this.adRepository.findById(id);
		ad.setEnabled(false);
		this.adRepository.save(ad);
	}
	
	public void enableById(long id) {
		Ad ad = this.adRepository.findById(id);
		ad.setEnabled(true);
		this.adRepository.save(ad);
	}
	
}
