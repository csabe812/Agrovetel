package com.agrovetel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Category;
import com.agrovetel.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
	
	public Category findById(long id) {
		return this.categoryRepository.findById(id);
	}
}
