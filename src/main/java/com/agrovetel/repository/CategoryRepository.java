package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
