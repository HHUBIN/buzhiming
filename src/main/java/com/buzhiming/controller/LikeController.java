package com.buzhiming.controller;

import com.buzhiming.DTO.ArticleDTO;
import com.buzhiming.DTO.LikeDTO;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.service.ArticleService;
import com.buzhiming.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikeController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/like/{id}")
    public ResultVO<LikeDTO> like(@PathVariable("id") String id){
            int count = commentService.updateCommentLike(id);
            int type = 0;
            if(count == -1){
                type = 1;
                count = articleService.updateArticleLike(id);
            }

            return new ResultVO<LikeDTO>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,new LikeDTO(count,type));
    }

}
