package com.firstSpringBoot.dto;

import com.firstSpringBoot.model.Category;
import com.firstSpringBoot.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDtoDetailed extends CategoryDto {
    @Getter @Setter
    private String username;
    @Getter @Setter
    private Status categoryStatus;
    @Getter @Setter
    private List<ReplyDto> replies;

    

    public CategoryDtoDetailed(Category category) {
        super(category);
        this.categoryStatus=category.getStatus();
        this.username=category.getUser().getName();
        this.replies=new ArrayList<>();
        this.replies.addAll(category.getReplies().stream().map(ReplyDto::new).collect(Collectors.toList()));
    }
}
