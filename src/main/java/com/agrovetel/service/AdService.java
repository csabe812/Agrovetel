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
		return (List<Ad>) adRepository.findAll();
	}
	
	/**
	 * Return with a list with all ad 
	 * sorted by a category
	 */
	public List<Ad> findAllByCategory(long i) {
		List<Ad> adList = (List<Ad>) adRepository.findAll();
		List<Ad> adListByCategory = new ArrayList<Ad>();
		for (Ad ad : adList) {
			if(ad.getCategory().getId()== i) {
				adListByCategory.add(ad);
			}
		}
		return adListByCategory;
	}
	
	/**
	 * Return with a list with all ad 
	 * sorted by a user
	 */
	public List<Ad> findAllByUser(long userId) {
		List<Ad> adList = (List<Ad>) adRepository.findAll();
		List<Ad> adListByUser = new ArrayList<Ad>();
		for (Ad ad : adList) {
			if(ad.getUser().getId()== userId) {
				adListByUser.add(ad);
			}
		}
		return adListByUser;
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
	
	/**
	 * Find all ads by county id
	 * @param id county_id
	 * @return the list of the ads
	 */
	public List<Ad> findAllByCountyId(long id) {
		return this.adRepository.findAllByCountyId(id);
	}
	
}
