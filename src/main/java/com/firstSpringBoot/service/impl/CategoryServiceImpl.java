package com.firstSpringBoot.service.impl;

import com.firstSpringBoot.dto.CategoryDto;
import com.firstSpringBoot.dto.CategoryDtoDetailed;
import com.firstSpringBoot.form.CategoryForm;
import com.firstSpringBoot.form.CategoryUpdateForm;
import com.firstSpringBoot.model.Category;
import com.firstSpringBoot.repository.CategoryRepository;
import com.firstSpringBoot.repository.CourseRepository;
import com.firstSpringBoot.service.CategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Page<CategoryDto> list(String courseName, Integer page, Integer limit) {
        Pageable pagination= PageRequest.of(page,limit);
        if(courseName == null) {
            Page<Category> categories = categoryRepository.findAll(pagination);
            return CategoryDto.convert(categories);
        }
        else {
            Page<Category> categories = categoryRepository.findByCourse_Name(courseName,pagination);
            return CategoryDto.convert(categories);
        }
    }

    @Override
    public ResponseEntity<CategoryDto> register(CategoryForm form, UriComponentsBuilder uriBuilder) {
        Category category=form.transform(courseRepository);
        categoryRepository.save(category);
        URI uri= uriBuilder.path("categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryDto(category));
    }

    @Override
    public CategoryDto specify(Long id) throws Exception {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new Exception("category doesnt exist"));
        return new CategoryDtoDetailed(category);
    }

    @Override
    public ResponseEntity<CategoryDto> update(Long id, @NotNull CategoryUpdateForm form) throws Exception {
        Category category =categoryRepository.findById(id).orElseThrow(() -> new Exception("user not found"));
        category.setTitle(form.getTitle());
        category.setMessage(form.getMessage());
        categoryRepository.save(category);
        return ResponseEntity.ok(new CategoryDto(category));
    }
}
