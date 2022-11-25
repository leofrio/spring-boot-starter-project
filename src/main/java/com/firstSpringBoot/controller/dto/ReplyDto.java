package com.firstSpringBoot.controller.dto;

import com.firstSpringBoot.model.Reply;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ReplyDto {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private LocalDateTime creationDate;
    @Getter @Setter
    private String userName;

    public ReplyDto() {
    }

    public ReplyDto(Reply reply) {
        this.id = reply.getId();
        this.message = reply.getMessage();
        this.creationDate = reply.getCreationDate();
        this.userName = reply.getUser().getName();
    }
}
