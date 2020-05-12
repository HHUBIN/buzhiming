package com.buzhiming.service;

import com.buzhiming.DTO.AnswersDTO;
import com.buzhiming.DTO.AskquestionDTO;
import com.buzhiming.DTO.AskquestionsDTO;
import com.buzhiming.DTO.PageRequest;
import com.buzhiming.model.Askquestion;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AskService {
    Askquestion saveAskquestion(AskquestionDTO askquestionDTO,String id);
    PageInfo<AskquestionsDTO> getAsks(PageRequest pageRequest);

    AnswersDTO getAskById(String id);

    List<AskquestionsDTO> getAskByUserId(String userid);
}
