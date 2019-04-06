package com.agrovetel.service;

import java.util.ArrayList;
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
		return (List<Ad>) adRepository.findAll();
	}
	
	public List<Ad> findAllByCategory(Long categoryId) {
		List<Ad> adList = (List<Ad>) adRepository.findAll();
		List<Ad> adListByCategory = new ArrayList<Ad>();
		for (Ad ad : adList) {
			if(ad.getCategory().getId()== categoryId) {
				adListByCategory.add(ad);
			}
		}
		return adListByCategory;
	}

	public AdRepository getAdRepository() {
		return adRepository;
	}

	public void setAdRepository(AdRepository adRepository) {
		this.adRepository = adRepository;
	};
	
}
