package com.agrovetel.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.agrovetel.controller.GeneralExceptionHandler;
import com.agrovetel.domain.Category;
import com.agrovetel.repository.CategoryRepository;
import com.agrovetel.service.exception.CategoryAlreadyExistsException;

/**
 * A service class for finding categori(es)
 * 
 * @author kafr007
 *
 */
@Service
public class CategoryService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

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
		log.info("save category");
		return this.categoryRepository.save(category);
	}

	/**
	 * Create a category
	 * 
	 * @param categoryName
	 * @return
	 */
	public Category createCategoryByCategoryName(String categoryName) throws CategoryAlreadyExistsException {
		if (categoryAlreadyExists(categoryName) == false) {
			Category category = new Category(categoryName);
			return this.categoryRepository.save(category);
		} else {
			throw new CategoryAlreadyExistsException("The " + categoryName + " category already exists.");
		}
	}

	/**
	 * Updates a category
	 * 
	 * @param updatedCategory
	 */
	public void updateCategory(long id, Category updatedCategory) throws CategoryAlreadyExistsException {
		Category category = this.categoryRepository.findById(id);
		log.info("" + updatedCategory.getName());
		if (categoryAlreadyExists(updatedCategory.getName()) == false) {
			category.setName(updatedCategory.getName());
			this.categoryRepository.save(category);
		} else {
			throw new CategoryAlreadyExistsException("The " + updatedCategory.getName() + " category already exists.");
		}

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

	public boolean categoryAlreadyExists(String categoryName) {
		categoryName = categoryName.toLowerCase();
		List<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			if (category.getName().toLowerCase().equals(categoryName)) {
				return true;
			}
		}
		return false;
	}

}
