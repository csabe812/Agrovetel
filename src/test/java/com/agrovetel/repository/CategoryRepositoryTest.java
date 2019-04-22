package com.agrovetel.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void testFindAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		assertNotNull(categories);
		assertTrue(!categories.isEmpty());
		assert(categories.size()==4);
	}
	
	@Test
	public void testById1() {
		Category category = categoryRepository.findById(1);
		assert(category.getName().equals("Tractor"));
		assert(category.isEnabled()== true);
	}
	
	@Test
	public void testById4() {
		Category category = categoryRepository.findById(4);
		assert(category.getName().equals("Other"));
		assert(category.isEnabled()== true);
	}

}
