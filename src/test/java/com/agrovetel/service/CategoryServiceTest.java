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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void testFindAll() {
		List<Category> categories = categoryService.findAll();
		assertNotNull(categories);
		assertTrue(!categories.isEmpty());
		assert(categories.size()==4);	
	}
	
	@Test
	public void testFindById2() {
		Category category = categoryService.findById(2);
		assert(category.getCategoryName().equals("Tyre"));
	}
	
	@Test
	public void testFindById3() {
		Category category = categoryService.findById(3);
		assert(category.getCategoryName().equals("Cultivator"));
	}

}
