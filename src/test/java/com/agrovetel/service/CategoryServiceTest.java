package com.agrovetel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agrovetel.domain.Category;
import com.agrovetel.service.exception.CategoryAlreadyExistsException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void testFindAll() {
		List<Category> categories = categoryService.findAllCategory();
		assertNotNull(categories);
		assertTrue(!categories.isEmpty());
		assert(categories.size()==4);	
	}
	
	@Test
	public void testFindById2() {
		Category category = categoryService.findCategoryById(2);
		assert(category.getName().equals("Tyre"));
	}
	
	@Test
	public void testFindById3() {
		Category category = categoryService.findCategoryById(3);
		assert(category.getName().equals("Cultivator"));
	}
	
	@Test
	public void testDisableCategoryById4() {
		categoryService.disableCategoryById(4);
		assert(categoryService.findCategoryById(4).isEnabled() == false);
	}
	
	@Test
	public void testEnableCategoryById3() {
		categoryService.enableCategoryById(3);
		assert(categoryService.findCategoryById(3).isEnabled() == true);
	}
	
	@Test
	public void testCategoryAlreadyExists() {
		assert(categoryService.categoryAlreadyExists("TraCtor") == true);
		assert(categoryService.categoryAlreadyExists("TRACTOR") == true);
		assert(categoryService.categoryAlreadyExists("TYRe") == true);
		assert(categoryService.categoryAlreadyExists("TyrE") == true);
		assert(categoryService.categoryAlreadyExists("CultivaTOR") == true);
		assert(categoryService.categoryAlreadyExists("Cultivator") == true);
		assert(categoryService.categoryAlreadyExists("Other") == true);
		assert(categoryService.categoryAlreadyExists("Valami") == false);
	}
	
	@Test(expected = CategoryAlreadyExistsException.class)
	public void testupdateCategoryThrowsCategoryAlreadyExistsException() throws CategoryAlreadyExistsException {
		categoryService.createCategoryByCategoryName("TRACTOR");
	}
	
	@Test(expected = CategoryAlreadyExistsException.class)
	public void testcCeateCategoryByCategoryNameThrowsCategoryAlreadyExistsException() throws CategoryAlreadyExistsException {
		Category updatedCategory = new Category("Other");
		categoryService.updateCategory(2, updatedCategory);
	}

}
