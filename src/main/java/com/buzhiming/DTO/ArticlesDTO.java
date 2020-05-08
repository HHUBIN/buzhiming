package com.buzhiming.DTO;

import com.buzhiming.model.Label;
import com.buzhiming.model.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticlesDTO {
    private String id;
    private User user;
    private String title;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;
    private Date createTime;
    private Date updateTime;
    private String content;
    private List<Label> labels;
}
