package com.buzhiming.DTO;

import com.buzhiming.model.Comment;
import com.buzhiming.model.Label;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class ArticleDTO {
    private String id;
    private String title;
    private List<Label> labels;
    private String content;
    private String authorId;
    private String authorName;
    private String authorImg;
    private Integer comment;
    private Integer like;
    private Integer view;
    private Date createTime;
    private List<CommentDTO> commentDTOS;
}
