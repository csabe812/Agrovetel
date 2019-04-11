package com.agrovetel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;
import com.agrovetel.repository.AdRepository;

@Service
public class AdService {
	
	@Autowired
	private AdRepository adRepository;
	
	public List<Ad> findAll() {
		return adRepository.findAll();
	}
		
	public List findByUser(long userId) {
		return adRepository.findByUserId(userId);
	}
	
	public List findByCategory(long categoryId) {
		return adRepository.findByCategoryId(categoryId);
	}
	
	public Ad findById(long id) {
		incrementNumberOfVisitors(id);
		return adRepository.findById(id);
	}
	
	public AdRepository getAdRepository() {
		return adRepository;
	}

	public void setAdRepository(AdRepository adRepository) {
		this.adRepository = adRepository;
	};
	
	public List<Ad> findAllByCategoryId(long id){
		return this.adRepository.findAllByCategoryId(id);
	}
	
	private void incrementNumberOfVisitors(long id) {
		Ad ad = adRepository.findById(id);
		int numberOfVisitors = ad.getNumberOfVisitors();
		numberOfVisitors++;
		ad.setNumberOfVisitors(numberOfVisitors);
		adRepository.save(ad);
		
	}
	
	/**
	 * Find all ads by county id
	 * @param id county_id
	 * @return the list of the ads
	 */
	public List<Ad> findAllByCountyId(long id) {
		return this.adRepository.findAllByCountyId(id);
	}
	
}
