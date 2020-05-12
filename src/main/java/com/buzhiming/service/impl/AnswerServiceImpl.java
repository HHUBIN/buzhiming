package com.buzhiming.service.impl;

import com.buzhiming.DTO.AnswerCommitDTO;
import com.buzhiming.mapper.AnswerMapper;
import com.buzhiming.mapper.AskquestionMapper;
import com.buzhiming.model.Answer;
import com.buzhiming.model.Askquestion;
import com.buzhiming.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AskquestionMapper askquestionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public void save(AnswerCommitDTO answerCommitDTO) {
        Answer answer = new Answer();
        answer.setId(UUID.randomUUID().toString());
        answer.setAskId(answerCommitDTO.getAskId());
        answer.setContent(answerCommitDTO.getContent());
        answer.setUserId(answerCommitDTO.getUserId());
        answer.setCommentCount(0);
        answer.setCreateTime(new Date());
        answer.setUpdateTime(new Date());
        answer.setLikeCount(0);
        System.out.println(answer);
        answerMapper.insert(answer);
        Askquestion askquestion = askquestionMapper.selectByPrimaryKey(answerCommitDTO.getAskId());
        askquestion.setCommentCount(askquestion.getCommentCount()+1);
        askquestionMapper.updateByPrimaryKey(askquestion);
    }
}
