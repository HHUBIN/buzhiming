package com.buzhiming.service;

import com.buzhiming.DTO.SubmitDTO;
import com.buzhiming.model.User;

public interface QusetionService {
    public String saveQuestion(User user, SubmitDTO submitDTO);
}
