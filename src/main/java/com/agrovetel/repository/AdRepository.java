package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;
import com.agrovetel.domain.User;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long>{
	
	Ad findById(long id);
	List<Ad> findAll();
	List<Ad> findByUserId(long userId);
	List<Ad> findByCategoryId(long categoryId);
}
