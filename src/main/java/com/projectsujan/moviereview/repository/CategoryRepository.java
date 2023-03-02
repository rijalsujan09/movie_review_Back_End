package com.projectsujan.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.moviereview.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
