package com.buzhiming;

import com.buzhiming.mapper.UserMapper;
import com.buzhiming.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuzhimingApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectByPrimaryKey("1");
        System.out.println(user);
    }

}
