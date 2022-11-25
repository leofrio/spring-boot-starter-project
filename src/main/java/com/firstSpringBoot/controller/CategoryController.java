package com.firstSpringBoot.controller;

import com.firstSpringBoot.controller.dto.CategoryDto;
import com.firstSpringBoot.controller.dto.CategoryDtoDetailed;
import com.firstSpringBoot.controller.form.CategoryForm;
import com.firstSpringBoot.controller.form.CategoryUpdateForm;
import com.firstSpringBoot.model.Category;
import com.firstSpringBoot.model.Course;
import com.firstSpringBoot.repository.CategoryRepository;
import com.firstSpringBoot.repository.CourseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping
    public Page<CategoryDto> list(@RequestParam(required = false) String courseName,@RequestParam(required = false,defaultValue = "0") Integer page,@RequestParam(required = false,defaultValue = "2") Integer limit) {
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
    @PostMapping
    public ResponseEntity<CategoryDto> register(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder) {
        Category category=form.transform(courseRepository);
        categoryRepository.save(category);
        URI uri= uriBuilder.path("categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryDto(category));
    }
    @GetMapping("/{id}")
    public CategoryDto specify(@PathVariable("id") Long id) throws Exception {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new Exception("category doesnt exist"));
        return new CategoryDtoDetailed(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable("id") Long id,@RequestBody @Valid @NotNull CategoryUpdateForm form) throws Exception {
        Category category=form.update(id,categoryRepository);
        categoryRepository.save(category);
        return ResponseEntity.ok(new CategoryDto(category));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        //categoryRepository.deleteById(id);
        if(categoryRepository.findById(id).isPresent()){
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
