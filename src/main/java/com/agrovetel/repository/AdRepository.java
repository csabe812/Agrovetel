package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Ad;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long>{

}
