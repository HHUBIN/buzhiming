package com.buzhiming.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommentDTO {
    private String id;
    private String authorImg;
    private String authorId;
    private String authorName;
    private String content;
    private Integer likeCount;
    private Integer commentCount;
    private Date createTime;
    private List<CommentDTO> list;
    private boolean show=false;
    private String userName;
    private String targetName;
    private Integer readStuate;
}
