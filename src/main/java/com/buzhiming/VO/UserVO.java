package com.buzhiming.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVO {
    private String id;
    private String name;
    private String imgUrl;
    private String token;
}
