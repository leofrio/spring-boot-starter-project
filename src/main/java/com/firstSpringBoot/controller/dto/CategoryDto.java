package com.firstSpringBoot.controller.dto;

import com.firstSpringBoot.model.Category;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto{
    @Getter
    private Long id;
    @Getter
    private String title;
    @Getter
    private String message;
    @Getter
    private LocalDateTime creationDate;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.message = category.getMessage();
        this.creationDate = category.getCreationDate();
    }

    public static List<CategoryDto> convert(List<Category> categories) {
         return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }
}
