package com.firstSpringBoot.repository;

import com.firstSpringBoot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> findByCourse_Name(String name, Pageable pagination);
}
