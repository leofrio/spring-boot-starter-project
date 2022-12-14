package com.firstSpringBoot.dto;

import com.firstSpringBoot.model.Category;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

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

    public static Page<CategoryDto> convert(Page<Category> categories) {
         return categories.map(CategoryDto::new);
    }
}
