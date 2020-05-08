package com.buzhiming.DTO;

import com.buzhiming.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class AskquestionsDTO {

    private String id;

    private User user;

    private String content;

    private Integer commentCount;

    private Date createTime;

    private Date updateTime;
}
