package com.buzhiming.controller;

import com.buzhiming.DTO.AnswerCommitDTO;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.service.AnswerService;
import com.buzhiming.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AnswerService answerService;
    @PostMapping("/answer")
    public ResultVO<Object> answer(@RequestBody AnswerCommitDTO answerCommitDTO){
        String s = (String)redisUtil.get(answerCommitDTO.getUserId());
        answerCommitDTO.setUserId(s);
        System.out.println(answerCommitDTO);
        answerService.save(answerCommitDTO);
        return new ResultVO<Object>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,null);
    }

}
