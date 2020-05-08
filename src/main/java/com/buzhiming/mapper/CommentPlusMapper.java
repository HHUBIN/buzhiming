package com.buzhiming.mapper;

import com.buzhiming.DTO.CommentDTO;
import com.buzhiming.model.Comment;
import com.buzhiming.model.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentPlusMapper {
  List<CommentDTO> getComments(String id);
  List<CommentDTO> getCommentsByUserName(String userName);
  void updateByTargetId(String userName);

    Integer getCommentsCountByUserName(String name);
}