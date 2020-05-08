package com.buzhiming.service;

import com.buzhiming.DTO.AnswersDTO;
import com.buzhiming.DTO.AskquestionDTO;
import com.buzhiming.DTO.AskquestionsDTO;
import com.buzhiming.model.Askquestion;

import java.util.List;

public interface AskService {
    Askquestion saveAskquestion(AskquestionDTO askquestionDTO,String id);
    List<AskquestionsDTO> getAsks();

    AnswersDTO getAskById(String id);

    List<AskquestionsDTO> getAskByUserId(String userid);
}
