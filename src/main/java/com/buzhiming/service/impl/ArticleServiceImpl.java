package com.buzhiming.service.impl;

import com.buzhiming.DTO.ArticleDTO;
import com.buzhiming.DTO.ArticlesDTO;
import com.buzhiming.DTO.CommentDTO;
import com.buzhiming.DTO.SubmitDTO;
import com.buzhiming.mapper.*;
import com.buzhiming.model.*;
import com.buzhiming.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private LabelRelatedPlusMapper labelRelatedPlusMapper;
    @Autowired
    private LabelRelatedMapper labelRelatedMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticlePlusMapper articlePlusMapper;
    @Autowired
    private CommentPlusMapper commentPlusMapper;
    @Override
    public String saveAricle(User user, SubmitDTO submitDTO) {
        Article article = new Article();
        article.setId(UUID.randomUUID().toString());
        article.setCommentCount(0);
        article.setLikeCount(0);
        article.setViewCount(0);
        article.setTitle(submitDTO.getTitle());
        article.setContent(submitDTO.getContent());
        article.setUserId(user.getId());
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        articleMapper.insert(article);
        LinkedList<LabelRelated> labelRelateds = new LinkedList<>();
        for (Label label: submitDTO.getLabel()) {
            LabelRelated labelRelated = new LabelRelated();
            labelRelated.setId(UUID.randomUUID().toString());
            labelRelated.setLabelId(label.getId());
            labelRelated.setTargetId(article.getId());
            labelRelated.setType(0);
            labelRelateds.add(labelRelated);
        }
        labelRelatedPlusMapper.insertLabelRelated(labelRelateds);
        return article.getId();
    }

    @Override
    public ArticleDTO getArticleDTOById(String id) {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = articleMapper.selectByPrimaryKey(id);
        if(article == null){
            return null;
        }
        articleDTO.setId(id);
        articleDTO.setTitle(article.getTitle());
        articleDTO.setContent(article.getContent());
        articleDTO.setAuthorId(article.getUserId());
        User user = userMapper.selectByPrimaryKey(article.getUserId());
        if(user != null){
            articleDTO.setAuthorName(user.getName());
            articleDTO.setAuthorImg(user.getImgUrl());
            articleDTO.setAuthorId(user.getId());
        }
        articleDTO.setComment(article.getCommentCount());
        articleDTO.setLike(article.getLikeCount());
        articleDTO.setView(article.getViewCount());
        articleDTO.setCreateTime(article.getCreateTime());
        System.out.println(article.getCreateTime());
        List<Label> labels = labelRelatedPlusMapper.selectLabelById(article.getId());
        articleDTO.setLabels(labels);
        List<CommentDTO> comments = commentPlusMapper.getComments(id);
        articleDTO.setCommentDTOS(comments);
        article.setViewCount((article.getViewCount()+1));
        articleMapper.updateByPrimaryKey(article);
        return articleDTO;
    }



    @Override
    public List<ArticlesDTO> getArticleDTOs() {
        return articlePlusMapper.getArticles();
    }

    @Override
    public List<ArticlesDTO> getArticleDTOsByUserId(String userId) {
        List<ArticlesDTO> articlesByUserId = articlePlusMapper.getArticlesByUserId(userId);
        return articlesByUserId;
    }

    @Override
    public void deleteById(String id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String updateArticle(User user, SubmitDTO submitDTO) {
        Article article = articleMapper.selectByPrimaryKey(submitDTO.getType());
        article.setTitle(submitDTO.getTitle());
        article.setContent(submitDTO.getContent());
        article.setUserId(user.getId());
        article.setUpdateTime(new Date());
        articlePlusMapper.updateByPrimaryKey(article);
        Article articlehjk = articleMapper.selectByPrimaryKey(submitDTO.getType());
        LinkedList<LabelRelated> labelRelateds = new LinkedList<>();
        for (Label label: submitDTO.getLabel()) {
            LabelRelated labelRelated = new LabelRelated();
            labelRelated.setId(UUID.randomUUID().toString());
            labelRelated.setLabelId(label.getId());
            labelRelated.setTargetId(article.getId());
            labelRelated.setType(0);
            labelRelateds.add(labelRelated);
        }
        LabelRelatedExample labelRelatedExample = new LabelRelatedExample();
        labelRelatedExample.createCriteria().andTargetIdEqualTo(article.getId());
        labelRelatedMapper.deleteByExample(labelRelatedExample);
        labelRelatedPlusMapper.insertLabelRelated(labelRelateds);
        return article.getId();
    }
}
