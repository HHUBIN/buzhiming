package com.buzhiming.DTO;

import com.buzhiming.model.Like;
import lombok.Data;

@Data
public class LikeDTO {
    public Integer count;
    public Integer type;
    public LikeDTO(int count,int type){
        this.count = count;
        this.type = type;
    }
}
