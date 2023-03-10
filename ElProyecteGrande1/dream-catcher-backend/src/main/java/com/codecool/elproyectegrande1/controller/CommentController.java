package com.codecool.elproyectegrande1.controller;


import com.codecool.elproyectegrande1.dto.CommentDto;
import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PutMapping("/{id}/like")
    public void likeComment(@PathVariable Long id) {
        commentService.likeComment(id);
    }

    @PutMapping("{id}/update-comment/{comment}/{updatedDate}")
    public void updateComment(@PathVariable Long id, @PathVariable String comment, @PathVariable LocalDateTime updatedDate) {
        commentService.updateComment(id, comment, updatedDate);
    }
}
