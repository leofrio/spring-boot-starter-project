package com.firstSpringBoot.controller;

import com.firstSpringBoot.controller.dto.CategoryDto;
import com.firstSpringBoot.model.Category;
import com.firstSpringBoot.model.Course;
import com.firstSpringBoot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping("/categories")
    public List<CategoryDto> list(String courseName) {
        if(courseName == null) {
            List<Category> categories = categoryRepository.findAll();
            return CategoryDto.convert(categories);
        }
        else {
            List<Category> categories = categoryRepository.findByCourse_Name(courseName);
            return CategoryDto.convert(categories);
        }

    }
}
