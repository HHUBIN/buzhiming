package com.buzhiming.DTO;

import com.buzhiming.model.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AnswerDTO {
    private String id;
    private User user;
    private String content;
    private Integer likeCount;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private List<Object> comments;
}
