package com.buzhiming.service;

import com.buzhiming.DTO.*;
import com.buzhiming.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
    public String saveAricle(User user, SubmitDTO submitDTO);

    ArticleDTO getArticleDTOById(String id);

    PageInfo<ArticlesDTO> getArticleDTOs(PageRequest pageRequest);

    List<ArticlesDTO> getArticleDTOsByUserId(String userId);

    void deleteById(String id);

    String updateArticle(User user, SubmitDTO submitDTO);

    int updateArticleLike(String id);
}
