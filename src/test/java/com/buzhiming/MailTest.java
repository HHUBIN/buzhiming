package com.buzhiming;

import com.buzhiming.service.impl.MaileService;
import com.buzhiming.utils.RedisUtil;
import com.mysql.cj.protocol.x.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;

@SpringBootTest
public class MailTest {
    @Autowired
    MaileService mailService;
    @Autowired
    RedisUtil redisUtil;
    @Test
    public void test() throws MessagingException {
        mailService.sendMail("1705030124@mail.hnust.edu.cn","asdf");
    }

    @Test
    public void testRedis() throws MessagingException {
        redisUtil.set("k1","v1",10);
        Object k1 = redisUtil.get("k2");
        System.out.println(k1);
    }
    @Test
    public void test2() throws MessagingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Notice> entity = restTemplate.getForEntity("https://api.github.com/user?access_token="
                , Notice.class);
    }


}
