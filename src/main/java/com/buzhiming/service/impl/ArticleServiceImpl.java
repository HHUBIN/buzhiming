package com.buzhiming.service.impl;

import com.buzhiming.DTO.*;
import com.buzhiming.mapper.*;
import com.buzhiming.model.*;
import com.buzhiming.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        if(user != null){
            article.setUserId(user.getId());
        }
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
        if(labelRelateds != null && labelRelateds.size() != 0){
            labelRelatedPlusMapper.insertLabelRelated(labelRelateds);
        }
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
    public PageInfo<ArticlesDTO> getArticleDTOs(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ArticlesDTO> sysMenus = articlePlusMapper.getArticles();
        if(pageRequest.getPageNum() == 1){
            List<ArticlesDTO> articlesByUserId = articlePlusMapper.getArticlesByUserId("1589204507878f3d1273c-3bd3-4250-a922-263e781076d4");
                sysMenus.add(0,articlesByUserId.get(articlesByUserId.size()-1));
        }
        for (ArticlesDTO aritclesDTO : sysMenus) {
            for(int i = 0; i < aritclesDTO.getContent().length(); i++) {
                if(aritclesDTO.getContent().charAt(i) == '['){
                    for(int j = i+1; j < aritclesDTO.getContent().length(); j++) {
                        if(aritclesDTO.getContent().charAt(j) == ']' && aritclesDTO.getContent().charAt(j+1) == '('){
                            for(int k = j+1; k < aritclesDTO.getContent().length(); k++) {
                                if(aritclesDTO.getContent().charAt(k) == ')') {
                                    aritclesDTO.setFirstImg(aritclesDTO.getContent().substring(j + 2, k));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(aritclesDTO.getContent().length() > 120){
                aritclesDTO.setContent(aritclesDTO.getContent().substring(0,120));
            }
        }
        return new PageInfo<ArticlesDTO>(sysMenus);
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
        if(labelRelateds != null && labelRelateds.size() > 0)
        labelRelatedPlusMapper.insertLabelRelated(labelRelateds);
        return article.getId();
    }

    @Override
    public int updateArticleLike(String id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        if(article != null){
            article.setLikeCount(article.getLikeCount()+1);
            articleMapper.updateByPrimaryKey(article);
            return article.getLikeCount();
        }else {
            return -1;
        }
    }
}
