package com.buzhiming.DTO;

import com.buzhiming.model.Label;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SubmitDTO {
    private String type;
    private String token;
    private String title;
    private List<Label> label;
    private String content;
}
