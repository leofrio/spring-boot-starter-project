package com.firstSpringBoot.service;

import com.firstSpringBoot.dto.CategoryDto;
import com.firstSpringBoot.form.CategoryForm;
import com.firstSpringBoot.form.CategoryUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@Service
public interface CategoryService {
    public Page<CategoryDto> list(String courseName, Integer page,Integer limit);
    public ResponseEntity<CategoryDto> register(CategoryForm form, UriComponentsBuilder uriBuilder);
    public CategoryDto specify(Long id) throws Exception;
    public ResponseEntity<CategoryDto> update(Long id,CategoryUpdateForm form) throws Exception;
}
