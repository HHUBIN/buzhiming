package com.buzhiming.service;

import com.buzhiming.DTO.CommentDTO;

import java.util.List;

public interface CommentService {
    void save(CommentDTO commentDTO);

    List<CommentDTO> getCommentByTarget(String id);
    List<CommentDTO> getCommentsByUserName(String userid);

    Integer getCountByUserId(String userid);
}
