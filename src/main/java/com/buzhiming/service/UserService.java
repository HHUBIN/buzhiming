package com.buzhiming.service;

import com.buzhiming.DTO.GithubUser;
import com.buzhiming.DTO.LoginDTO;
import com.buzhiming.DTO.RegisterDTO;
import com.buzhiming.model.User;

import java.io.IOException;
import java.net.MalformedURLException;

public interface UserService {
    public User getUser(LoginDTO loginDTO);
    public User getUser(User user);
    public void updateUser(User user);
    public void saveUser(RegisterDTO registerDTO);
    public User saveUser(GithubUser user) throws IOException;
    public User getUserById(String id);

    User getUserByName(String name);
}
