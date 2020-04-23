package com.buzhiming.service.impl;

import com.buzhiming.DTO.GithubUser;
import com.buzhiming.DTO.LoginDTO;
import com.buzhiming.DTO.RegisterDTO;
import com.buzhiming.mapper.UserMapper;
import com.buzhiming.model.User;
import com.buzhiming.model.UserExample;
import com.buzhiming.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id){
        return userMapper.selectByPrimaryKey(id);
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
        user.setId(System.currentTimeMillis()+UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public User saveUser(GithubUser githubUser) {
        User user = new User();
        user.setId(System.currentTimeMillis()+UUID.randomUUID().toString());
        user.setAccountId(githubUser.getId());
        user.setImgUrl(githubUser.getAvatar_url());
        user.setName(githubUser.getName());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        return user;
    }
}
