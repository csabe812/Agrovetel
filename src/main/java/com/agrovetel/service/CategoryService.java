package com.agrovetel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Category;
import com.agrovetel.repository.CategoryRepository;

/**
 * A service class for finding categori(es)
 * 
 * @author kafr007
 *
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Finding all the categories
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	/**
	 * Finding a category by its id
	 * 
	 * @param id
	 * @return
	 */
	public Category findById(long id) {
		return this.categoryRepository.findById(id);
	}
}
