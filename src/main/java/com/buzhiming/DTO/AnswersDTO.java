package com.buzhiming.DTO;

import com.buzhiming.model.Answer;
import com.buzhiming.model.Askquestion;
import lombok.Data;

import java.util.List;
@Data
public class AnswersDTO {
    private AskquestionsDTO askquestionsDTO;
    private List<AnswerDTO> AnswerDTOS;
}
