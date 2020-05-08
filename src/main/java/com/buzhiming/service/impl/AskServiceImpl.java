package com.buzhiming.service.impl;

import com.buzhiming.DTO.AnswerDTO;
import com.buzhiming.DTO.AnswersDTO;
import com.buzhiming.DTO.AskquestionDTO;
import com.buzhiming.DTO.AskquestionsDTO;
import com.buzhiming.mapper.*;
import com.buzhiming.model.*;
import com.buzhiming.service.AskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class AskServiceImpl implements AskService {

    @Autowired
    private AskquestionMapper askquestionMapper;
    @Autowired
    private AskquestionPlusMapper askquestionPlusMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private AnswerPlusMapper answerPlusMapper;
    @Override
    public Askquestion saveAskquestion(AskquestionDTO askquestionDTO,String id) {

        Askquestion askquestion = new Askquestion();
        askquestion.setId(UUID.randomUUID().toString());
        askquestion.setCommentCount(0);
        askquestion.setContent(askquestionDTO.getContent());
        askquestion.setUserId(id);
        askquestion.setCreateTime(new Date());
        askquestion.setUpdateTime(new Date());
        askquestionMapper.insert(askquestion);
        return askquestion;
    }

    @Override
    public List<AskquestionsDTO> getAsks() {
        List<AskquestionsDTO> askquestions = askquestionPlusMapper.getAsks();
        Collections.reverse(askquestions);
        return askquestions;
    }

    @Override
    public AnswersDTO getAskById(String id) {
        AskquestionsDTO ask = askquestionPlusMapper.getAsk(id);

        List<AnswerDTO> answerDTOS = answerPlusMapper.getAnswers(id);
        Collections.reverse(answerDTOS);
        AnswersDTO answersDTO = new AnswersDTO();
        answersDTO.setAskquestionsDTO(ask);
        answersDTO.setAnswerDTOS(answerDTOS);
        return answersDTO;
    }

    @Override
    public List<AskquestionsDTO> getAskByUserId(String userid) {
        List<AskquestionsDTO> askquestions = askquestionPlusMapper.getAsksByUserId(userid);
        return askquestions;
    }
}
