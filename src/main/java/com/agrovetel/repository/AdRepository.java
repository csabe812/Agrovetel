package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long>{

	List<Ad> findAllByCategoryId(long id);
	
	List<Ad> findAllByCountyId(long id);
	
}
