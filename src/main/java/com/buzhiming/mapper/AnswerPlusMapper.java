package com.buzhiming.mapper;

import com.buzhiming.DTO.AnswerDTO;


import java.util.List;

public interface AnswerPlusMapper {
    List<AnswerDTO> getAnswers(String id);
}
