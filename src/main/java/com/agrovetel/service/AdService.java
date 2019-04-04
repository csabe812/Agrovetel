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
		return (List<Ad>) adRepository.findAll();
	};
	

}
