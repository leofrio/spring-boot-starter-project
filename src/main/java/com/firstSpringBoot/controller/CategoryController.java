package com.firstSpringBoot.controller;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public Page<CategoryDto> list(@RequestParam(required = false) String courseName,@RequestParam(required = false,defaultValue = "0") Integer page,@RequestParam(required = false,defaultValue = "2") Integer limit) {
       return categoryService.list(courseName,page,limit);
    }
    @PostMapping
    public ResponseEntity<CategoryDto> register(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder) {
        return categoryService.register(form,uriBuilder);
    }
    @GetMapping("/{id}")
    public CategoryDto specify(@PathVariable("id") Long id) throws Exception {
        return categoryService.specify(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable("id") Long id,@RequestBody @Valid @NotNull CategoryUpdateForm form) throws Exception {
        return categoryService.update(id,form);
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
