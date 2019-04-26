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
	List<Ad> findAllByCategoryId(long categoryId);
	List<Ad> findAllByCountyId(long countyId);
	List<Ad> findAllByUserId(long userId);
	List<Ad> findAllByUserIdAndEnabled(long userId, boolean enabled);
	List<Ad> findByCategoryId(long categoryId);
	void deleteById(long id);
	
}
