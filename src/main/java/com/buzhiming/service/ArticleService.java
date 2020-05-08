package com.buzhiming.service;

import com.buzhiming.DTO.ArticleDTO;
import com.buzhiming.DTO.ArticlesDTO;
import com.buzhiming.DTO.SubmitDTO;
import com.buzhiming.model.User;

import java.util.List;

public interface ArticleService {
    public String saveAricle(User user, SubmitDTO submitDTO);

    ArticleDTO getArticleDTOById(String id);

    List<ArticlesDTO> getArticleDTOs();

    List<ArticlesDTO> getArticleDTOsByUserId(String userId);

    void deleteById(String id);

    String updateArticle(User user, SubmitDTO submitDTO);
}
