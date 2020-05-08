package com.buzhiming.service.impl;

import com.buzhiming.DTO.CommentDTO;
import com.buzhiming.mapper.*;
import com.buzhiming.model.*;
import com.buzhiming.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ArticleMapper articleMapper;
   @Autowired
   private AnswerMapper answerMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentPlusMapper commentPlusMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void save(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setUserId(commentDTO.getAuthorId());
        comment.setTarget(commentDTO.getId());
        comment.setCommentCount(0);
        comment.setContent(commentDTO.getContent());
        comment.setLikeCount(0);
        comment.setReadStuate(0);
        comment.setCreateTime(new Date());
        if(commentDTO.getTargetName() != null){
            comment.setTargetId(commentDTO.getTargetName());
        }
        Article article = articleMapper.selectByPrimaryKey(commentDTO.getId());
        Answer answer = answerMapper.selectByPrimaryKey(commentDTO.getId());
        if(article != null){
            article.setCommentCount(article.getCommentCount()+1);
            articleMapper.updateByPrimaryKey(article);
            User user = userMapper.selectByPrimaryKey(article.getUserId());
            if(commentDTO.getTargetName() == null){
                comment.setTargetId(user.getName());
            }
        }else if(answer != null){
            answer.setCommentCount(answer.getCommentCount()+1);
            answerMapper.updateByPrimaryKey(answer);
            User user = userMapper.selectByPrimaryKey(answer.getUserId());
            if(commentDTO.getTargetName() == null){
                comment.setTargetId(user.getName());
            }
        }else {
            Comment comment1 = commentMapper.selectByPrimaryKey(commentDTO.getId());
            comment1.setCommentCount(comment1.getCommentCount()+1);
            commentMapper.updateByPrimaryKey(comment1);
            User user = userMapper.selectByPrimaryKey(comment1.getUserId());
            if(commentDTO.getTargetName() == null){
                comment.setTargetId(user.getName());
            }
        }
        commentMapper.insert(comment);
    }

    @Override
    public List<CommentDTO> getCommentByTarget(String id) {
        List<CommentDTO> comments = commentPlusMapper.getComments(id);
        return comments;
    }

    @Override
    public List<CommentDTO> getCommentsByUserName(String userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        List<CommentDTO> comments = commentPlusMapper.getCommentsByUserName(user.getName());
        commentPlusMapper.updateByTargetId(user.getName());
        return comments;
    }

    @Override
    public Integer getCountByUserId(String userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        System.out.println(user.getName());
        Integer count= commentPlusMapper.getCommentsCountByUserName(user.getName());
        System.out.println(count);
        return count;
    }
}
