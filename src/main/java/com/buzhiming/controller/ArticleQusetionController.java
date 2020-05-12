package com.buzhiming.controller;

import com.buzhiming.DTO.ArticleDTO;
import com.buzhiming.DTO.ArticlesDTO;
import com.buzhiming.DTO.PageRequest;
import com.buzhiming.DTO.SubmitDTO;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.model.User;
import com.buzhiming.service.ArticleService;
import com.buzhiming.service.QusetionService;
import com.buzhiming.service.UserService;
import com.buzhiming.utils.RedisUtil;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleQusetionController {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private QusetionService qusetionService;

    /**
     * 问题或文章提交
     * @param submitDTO
     * @return
     */
    @PostMapping("/submit")
    public ResultVO<String> submit(@RequestBody SubmitDTO submitDTO){
        String resultId = null;
        if(submitDTO.getToken() == null){
            if(submitDTO.getType().equals("article")){
                resultId = articleService.saveAricle(new User(), submitDTO);
            }else {
                return new ResultVO<>(CodeEnum.FAILURE.id,CodeEnum.FAILURE.message,null);
            }
            return new ResultVO<>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,resultId);
        }
        String id = (String)redisUtil.get(submitDTO.getToken());
        User user = userService.getUserById(id);
        System.out.println();
        if(submitDTO.getType().equals("article")){
            resultId = articleService.saveAricle(user, submitDTO);
        }else {
            resultId = articleService.updateArticle(user, submitDTO);
        }

        return new ResultVO<>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,resultId);
    }
    /**
     * 文章页面的获取
     * @param
     * @return
     */
    @GetMapping("/article/{id}")
    public ResultVO<ArticleDTO> submit(@PathVariable("id") String id){
        ArticleDTO articleDTO = articleService.getArticleDTOById(id);
        if(articleDTO == null){
            return new ResultVO<ArticleDTO>(CodeEnum.FAILURE.id,CodeEnum.FAILURE.message,null);
        }
        if(articleDTO.getLike() == null){
            articleDTO.setLike(0);
        }
        if(articleDTO.getView() == null){
            articleDTO.setView(0);
        }
        if(articleDTO.getComment() == null){
            articleDTO.setComment(0);
        }
        return new ResultVO<ArticleDTO>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,articleDTO);
    }
    @PostMapping("/articles")
    public ResultVO<PageInfo<ArticlesDTO>> articles(@RequestBody PageRequest request){
        PageInfo<ArticlesDTO> articleDTOs = articleService.getArticleDTOs(request);
        return new ResultVO<PageInfo<ArticlesDTO>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,articleDTOs);

    }

    @GetMapping("/articles/{userid}")
    public ResultVO<List<ArticlesDTO>> articlesByUserId(@PathVariable("userid") String id){
        List<ArticlesDTO> articleDTOs = articleService.getArticleDTOsByUserId(id);
        return new ResultVO<List<ArticlesDTO>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,articleDTOs);

    }
    @DeleteMapping("/article/{id}")
    public ResultVO<Object> deleteById(@PathVariable("id") String id){
        articleService.deleteById(id);
        return new ResultVO<Object>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,null);

    }
}
