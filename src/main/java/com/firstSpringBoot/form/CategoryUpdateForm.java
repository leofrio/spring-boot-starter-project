package com.firstSpringBoot.form;

import com.firstSpringBoot.model.Category;
import com.firstSpringBoot.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryUpdateForm {
    @Getter
    @Setter
    @NotNull @NotEmpty @Length(min = 3)
    private String title;
    @Getter @Setter
    @NotNull @NotEmpty @Length(min = 3)
    private String message;

    //take out put in service
}
