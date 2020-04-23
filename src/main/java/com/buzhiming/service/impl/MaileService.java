package com.buzhiming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MaileService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;


    /**
     * 简单文本邮件
     *
     * @param to      接收者邮件
     * @param code 邮件内容
     */
    public void sendMail(String to, String code) throws MessagingException {
        code = "<html>\n" +
                "<body>\n" +
                "【不知名社区】你好!你的验证码为：\n" +
                "<font size=\"6\"><strong>"+code+"</strong></font>\n" +
                "<body>\n" +
                "</html>\n";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject("不知名社区邮箱验证");
        helper.setText(code, true);
        helper.setFrom(from);
        mailSender.send(message);

    }
}
