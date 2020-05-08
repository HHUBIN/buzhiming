package com.buzhiming.controller;

import com.buzhiming.DTO.CommentDTO;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.service.CommentService;
import com.buzhiming.utils.RedisUtil;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CommentService commentService;
    @PostMapping("/submitComment")
    public ResultVO<String> submitComment(@RequestBody CommentDTO commentDTO){
        if(commentDTO.getAuthorId() == null){
            commentService.save(commentDTO);
        }else {
            String id = (String) redisUtil.get(commentDTO.getAuthorId());
            commentDTO.setAuthorId(id);
            commentService.save(commentDTO);
        }
        return new ResultVO<String>(CodeEnum.SUCCESS.id, CodeEnum.SUCCESS.message,null);
    }
    @GetMapping("/comment/{id}")
    public ResultVO<List<CommentDTO>> comment(@PathVariable("id")String id){
        List<CommentDTO> list = commentService.getCommentByTarget(id);
        System.out.println(list);
        return new ResultVO<List<CommentDTO>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,list);
    }
    @GetMapping("/comments/{userid}")
    public ResultVO<List<CommentDTO>> comments(@PathVariable("userid")String userid){
        List<CommentDTO> list = commentService.getCommentsByUserName(userid);
        return new ResultVO<List<CommentDTO>>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,list);
    }
    @GetMapping("/noticecount/{userid}")
    public ResultVO<Integer> commentsCount(@PathVariable("userid")String userid){
        Integer count= commentService.getCountByUserId(userid);
        System.out.println(count);
        return new ResultVO<Integer>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,count);
    }

}
