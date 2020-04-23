package com.buzhiming.service;

import com.buzhiming.DTO.GithubUser;
import com.buzhiming.DTO.LoginDTO;
import com.buzhiming.DTO.RegisterDTO;
import com.buzhiming.model.User;

public interface UserService {
    public User getUser(LoginDTO loginDTO);
    public User getUser(User user);
    public void updateUser(User user);
    public void saveUser(RegisterDTO registerDTO);
    public User saveUser(GithubUser user);
}
