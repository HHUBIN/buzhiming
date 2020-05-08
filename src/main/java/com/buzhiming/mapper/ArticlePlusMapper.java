package com.buzhiming.mapper;

import com.buzhiming.DTO.ArticlesDTO;
import com.buzhiming.model.Article;


import java.util.List;

public interface ArticlePlusMapper {
    List<ArticlesDTO> getArticles();
    List<ArticlesDTO> getArticlesByUserId(String userId);

    void updateByPrimaryKey(Article article);
}