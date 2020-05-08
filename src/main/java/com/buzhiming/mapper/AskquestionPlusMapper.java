package com.buzhiming.mapper;

import com.buzhiming.DTO.AskquestionDTO;
import com.buzhiming.DTO.AskquestionsDTO;

import java.util.List;

public interface AskquestionPlusMapper {
    public List<AskquestionsDTO> getAsks();
    AskquestionsDTO getAsk(String id);

    List<AskquestionsDTO> getAsksByUserId(String userid);
}
