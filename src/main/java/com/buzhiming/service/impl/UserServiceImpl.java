package com.buzhiming.service.impl;

import com.buzhiming.DTO.GithubUser;
import com.buzhiming.DTO.LoginDTO;
import com.buzhiming.DTO.RegisterDTO;
import com.buzhiming.mapper.UserMapper;
import com.buzhiming.model.User;
import com.buzhiming.model.UserExample;
import com.buzhiming.provider.UCloudProvider;
import com.buzhiming.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UCloudProvider uCloudProvider;
    public User getUserById(String id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByName(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() == 0){
            return  null;
        }
        return users.get(0);
    }

    @Override
    public User getUser(LoginDTO loginDTO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(loginDTO.getName());
        criteria.andPasswordEqualTo(loginDTO.getPassword());
        List<User> user = userMapper.selectByExample(userExample);
        if(user == null || user.size() == 0){
            userExample = new UserExample();
            userExample.createCriteria()
                    .andPasswordEqualTo(loginDTO.getPassword())
                    .andEmailEqualTo(loginDTO.getName());
            user = userMapper.selectByExample(userExample);
        }
        if(user == null || user.size() == 0) return null;
        return user.get(0);
    }

    @Override
    public User getUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() == 0){
            return null;
        }
        return users.get(0);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void saveUser(RegisterDTO registerDTO) {
        User user = new User();
        BeanUtils.copyProperties(registerDTO,user);
        if(user.getId() == null){
            user.setId(System.currentTimeMillis()+UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insert(user);
        }else{
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKey(user);
        }

    }

    @Override
    public User saveUser(GithubUser githubUser) throws IOException {
        User user = new User();
        user.setId(System.currentTimeMillis()+UUID.randomUUID().toString());
        user.setAccountId(githubUser.getId());

/*        // 构造URL
        URL url = new URL(githubUser.getAvatar_url());
        // 打开连接
        URLConnection con = url.openConnection();

        //超时响应时间为10秒
        con.setConnectTimeout(100 * 1000);
        // 输入流
        InputStream is = con.getInputStream();
        String upload = uCloudProvider.upload(is, "image/jpeg", user.getId() + ".jpg");*/
        user.setImgUrl(githubUser.getAvatar_url());

        user.setName(githubUser.getName());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        return user;
    }
}
