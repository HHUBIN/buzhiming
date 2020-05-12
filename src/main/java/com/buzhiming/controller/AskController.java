package com.buzhiming.controller;

import com.buzhiming.DTO.AnswersDTO;
import com.buzhiming.DTO.AskquestionDTO;
import com.buzhiming.DTO.AskquestionsDTO;
import com.buzhiming.DTO.PageRequest;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.model.Askquestion;
import com.buzhiming.service.AskService;
import com.buzhiming.utils.RedisUtil;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AskController {
    @Autowired
    private AskService askService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/ask")
    public ResultVO<Askquestion> postAsk(@RequestBody AskquestionDTO askquestionDTO){
        if(askquestionDTO.getToken() == null || askquestionDTO.getToken().equals("")){
            Askquestion askquestion = askService.saveAskquestion(askquestionDTO,null);
            return new ResultVO<Askquestion>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,askquestion);
        }
        System.out.println(askquestionDTO.getToken());
        String id = (String)redisUtil.get(askquestionDTO.getToken());
        System.out.println(id);
        Askquestion askquestion = askService.saveAskquestion(askquestionDTO,id);
        return new ResultVO<Askquestion>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,askquestion);
    }

    @PostMapping("/asks")
    public ResultVO<PageInfo<AskquestionsDTO>> asks(@RequestBody PageRequest pageRequest){
        PageInfo<AskquestionsDTO> pageInfo= askService.getAsks(pageRequest);
        return new ResultVO<PageInfo<AskquestionsDTO>>(CodeEnum.SUCCESS.id, CodeEnum.SUCCESS.message,pageInfo);
    }

    @GetMapping("/question/{id}")
    public ResultVO<AnswersDTO> asks(@PathVariable("id") String id){
        AnswersDTO answersDTO = askService.getAskById(id);
        return new ResultVO<AnswersDTO>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,answersDTO);
    }
    @GetMapping("/questions/{userid}")
    public ResultVO<List<AskquestionsDTO>> question(@PathVariable("userid") String userid){
        List<AskquestionsDTO> asks = askService.getAskByUserId(userid);
        return new ResultVO<List<AskquestionsDTO>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,asks);
    }
}
