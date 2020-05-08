package com.buzhiming.controller;

import com.buzhiming.DTO.AccessTokenDTO;
import com.buzhiming.DTO.GithubUser;
import com.buzhiming.DTO.LoginDTO;
import com.buzhiming.DTO.RegisterDTO;
import com.buzhiming.VO.ResultVO;
import com.buzhiming.VO.UserVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.mapper.UserMapper;
import com.buzhiming.model.User;
import com.buzhiming.provider.GithubProvider;
import com.buzhiming.service.UserService;
import com.buzhiming.service.impl.MaileService;
import com.buzhiming.service.impl.UserServiceImpl;
import com.buzhiming.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MaileService maileService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;


    @ResponseBody
    @PostMapping("/login")
    public ResultVO<UserVO> login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO);
        User user = userService.getUser(loginDTO);
        if(user == null){
            return new ResultVO<UserVO>(CodeEnum.LOGIN_FAILURE.id,CodeEnum.LOGIN_FAILURE.message,null);
        }
        String token = UUID.randomUUID().toString();
        redisUtil.set(token,user.getId(),3600*24*7);
        UserVO userVO = new UserVO(user.getId(), user.getName(), user.getImgUrl(), token);
        ResultVO<UserVO> userVOResultVO = new ResultVO<>(CodeEnum.LOGIN_SUCCESS.id,CodeEnum.LOGIN_SUCCESS.message,userVO);
        return userVOResultVO;
    }
    @ResponseBody
    @GetMapping("/emailCode/{email}")
    public ResultVO<Object> emailCode(@PathVariable("email") String email){
        String code = UUID.randomUUID().toString().substring(0,4);
        try {
            System.out.println(1);
            maileService.sendMail(email,code);
            System.out.println(2);
            redisUtil.set(email,code,300);
            System.out.println(code);
        } catch(MessagingException e) {
            e.printStackTrace();
        }
        return new ResultVO<Object>(CodeEnum.GETEMAILCODE_SUCCESS.id,CodeEnum.GETEMAILCODE_SUCCESS.message,null);
    }
    @ResponseBody
    @PostMapping("/register")
    public ResultVO<Object> register(@RequestBody RegisterDTO registerDTO){
        if(registerDTO.getId() == null){
            String code = (String) redisUtil.get(registerDTO.getEmail());
            if(code == null || !registerDTO.getEmailCode().equals(code)){
                return new ResultVO<Object>(CodeEnum.REGISTER_ERROR.id,CodeEnum.REGISTER_ERROR.message,null);
            }
        }
        userService.saveUser(registerDTO);
        return new ResultVO<Object>(CodeEnum.REGISTER_SUCCESS.id,CodeEnum.REGISTER_SUCCESS.message,null);
    }
    @ResponseBody
    @GetMapping("/user/{token}")
    public ResultVO<UserVO> user(@PathVariable("token") String token){
        User user = userService.getUserById(String.valueOf(redisUtil.get(token)));
        if(user == null){
            return new ResultVO<UserVO>(CodeEnum.LOGIN_FAILURE.id,CodeEnum.LOGIN_FAILURE.message,null);
        }
        UserVO userVO = new UserVO(user.getId(), user.getName(), user.getImgUrl(), token);
        return new ResultVO<UserVO>(CodeEnum.LOGIN_SUCCESS.id,CodeEnum.LOGIN_SUCCESS.message,userVO);
    }
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           Model model) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser);
        if(githubUser != null && githubUser.getId() != null) {
            User user1 = new User();
            user1.setAccountId(githubUser.getId());
            User user2 = userService.getUser(user1);
            String token = UUID.randomUUID().toString();System.out.println(token);
            if(user2 == null){
                User user = userService.saveUser(githubUser);
                redisUtil.set(token,user.getId(),3600*24*7);
            }else {
                redisUtil.set(token,user2.getId(),3600*24*7);
            }
            model.addAttribute("token",token);
        }else {
            model.addAttribute("token","");
        }

        System.out.println("转到授权页面");
        return "auth";
    }
}
