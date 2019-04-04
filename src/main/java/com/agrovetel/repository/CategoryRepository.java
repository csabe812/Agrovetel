package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;

import com.agrovetel.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
