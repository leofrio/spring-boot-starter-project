package com.firstSpringBoot.form;

import com.firstSpringBoot.model.Category;
import com.firstSpringBoot.repository.CourseRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryForm {
    @Getter @Setter
    @NotNull @NotEmpty @Length(min = 3)
    private String title;
    @Getter @Setter
    @NotNull @NotEmpty @Length(min = 3)
    private String message;
    @Getter @Setter
    @NotNull @NotEmpty @Length(min = 3)
    private String courseName;

    public Category transform(CourseRepository courseRepository) {
        return  new Category(title,message,courseRepository.findByName(courseName));
    }
}
