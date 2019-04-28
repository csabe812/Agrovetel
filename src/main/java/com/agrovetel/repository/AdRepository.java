package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Ad;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {

	Ad findById(long id);

	List<Ad> findAll();

	List<Ad> findAllByCategoryId(long categoryId);

	List<Ad> findAllByCountyId(long countyId);
	
	List<Ad> findAllByManufacturerId(long manufacturerId);

	List<Ad> findAllByUserId(long userId);

	List<Ad> findAllByUserIdAndEnabled(long userId, boolean enabled);

	List<Ad> findByCategoryId(long categoryId);
	
	List<Ad> findByCountyId(long countyId);
	
	List<Ad> findByPriceBetweenOrderByPriceAsc(double bottomPrice, double topPrice);
	
	List<Ad> findByPriceBetweenOrderByPriceDesc(double bottomPrice, double topPrice);
	
	List<Ad> findByPriceGreaterThanOrderByPriceAsc(double bottomPrice);
	
	List<Ad> findByPriceGreaterThanOrderByPriceDesc(double bottomPrice);
	
	List<Ad> findByPriceLessThanOrderByPriceAsc(double topPrice);
	
	List<Ad> findByPriceLessThanOrderByPriceDesc(double topPrice);
	
	List<Ad> findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsAsc(int bottomNumberOfVisitors, int topNumberOfVisitors);
	
	List<Ad> findByNumberOfVisitorsBetweenOrderByNumberOfVisitorsDesc(int bottomNumberOfVisitors, int topNumberOfVisitors);
	
	List<Ad> findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsAsc(int bottomNumberOfVisitors);
	
	List<Ad> findByNumberOfVisitorsGreaterThanOrderByNumberOfVisitorsDesc(int bottomNumberOfVisitors);
	
	List<Ad> findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsAsc(int topNumberOfVisitors);
	
	List<Ad> findByNumberOfVisitorsLessThanOrderByNumberOfVisitorsDesc(int topNumberOfVisitors);
	
	List<Ad> findBySellSearchTrue();
	
	List<Ad> findBySellSearchFalse();

	void deleteById(long id);

}
