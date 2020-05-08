package com.buzhiming.controller;

import com.buzhiming.DTO.RegisterDTO;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.model.User;
import com.buzhiming.service.UserService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResultVO<User> getUserByName(@RequestBody RegisterDTO registerDTO){
        User userByName = userService.getUserByName(registerDTO.getName());
        if(userByName == null){
            return new ResultVO<User>(CodeEnum.FAILURE.id,CodeEnum.FAILURE.message,null);
        }
        return new ResultVO<User>(CodeEnum.SUCCESS.id,CodeEnum.SUCCESS.message,userByName);
    }
    @GetMapping("/userinfo/{id}")
    public ResultVO<User> getUserInfo(@PathVariable("id") String string){
        return new ResultVO<User>(CodeEnum.SUCCESS.id, CodeEnum.SUCCESS.message,null);
    }
}
