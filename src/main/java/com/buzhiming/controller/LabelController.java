package com.buzhiming.controller;

import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.model.Label;
import com.buzhiming.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;
    @GetMapping("/label")
    public ResultVO<List<Label>> label(){

        List<Label> label = labelService.getLabel();

        return new ResultVO<List<Label>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,label);
    }

    @GetMapping("/newlabel/{name}")
    public ResultVO<List<Label>> newLabel(@PathVariable("name")String name){

        List<Label> label = labelService.saveLabel(name);

        return new ResultVO<List<Label>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,label);
    }
}
