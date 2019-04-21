package com.agrovetel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;
import com.agrovetel.repository.AdRepository;
import com.agrovetel.repository.CategoryRepository;

/**
 * A service class for finding categori(es)
 * 
 * @author kafr007
 *
 */
@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	/**
	 * Setter-base autowiring
	 * 
	 * @param categoryRepository
	 */
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	/**
	 * Finding all the categories
	 * 
	 * @return
	 */
	public List<Category> findAllCategory() {
		return this.categoryRepository.findAll();
	}

	/**
	 * Finding a category by its id
	 * 
	 * @param id
	 * @return
	 */
	public Category findCategoryById(long id) {
		return this.categoryRepository.findById(id);
	}

	/**
	 * Updating/create a category
	 * 
	 * @param category
	 * @return
	 */
	public Category updateCreateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	/**
	 * Updates a category
	 * 
	 * @param updatedCategory
	 */
	public void updateCategory(long id, Category updatedCategory) {
		Category category = this.categoryRepository.findById(id);
		category.setCategoryName(updatedCategory.getCategoryName());
		this.categoryRepository.save(category);
	}

	/**
	 * Deleting a category by its id
	 * 
	 * @param id
	 */
	public void deleteCategoryById(long id) {
		this.categoryRepository.deleteById(id);
	}

	/**
	 * Disable a category by its id
	 * 
	 * @param id
	 */
	public void disableCategoryById(long id) {
		Category category = this.categoryRepository.findById(id);
		category.setEnabled(false);
		this.categoryRepository.save(category);
	}

	/**
	 * Enable a category by its id
	 * 
	 * @param id
	 */
	public void enableCategoryById(long id) {
		Category category = this.categoryRepository.findById(id);
		category.setEnabled(true);
		this.categoryRepository.save(category);
	}

}
