package com.buzhiming.provider;


import com.alibaba.fastjson.JSON;
import com.buzhiming.DTO.AccessTokenDTO;
import com.buzhiming.DTO.GithubUser;
import com.mysql.cj.protocol.x.Notice;
import okhttp3.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                 String string = response.body().string();
                System.out.println("==========token对象"+string);
                 String token = string.split("&")[0].split("=")[1];
                return token;
            } catch(IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .header("User-Agent","buzhiming").build();
        try{
            Response response = client.newCall(request).execute();
            String string  = response.body().string();
            System.out.println(string);
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
