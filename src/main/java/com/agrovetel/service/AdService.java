package com.agrovetel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Ad;
import com.agrovetel.repository.AdRepository;

@Service
public class AdService {
	
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
	};
	
}
