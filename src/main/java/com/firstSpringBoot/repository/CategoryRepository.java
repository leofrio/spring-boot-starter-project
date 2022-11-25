package com.firstSpringBoot.repository;

import com.firstSpringBoot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> findByCourse_Name(String name, Pageable pagination);
}
