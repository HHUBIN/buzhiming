package com.buzhiming.provider;

import cn.ucloud.ufile.UfileClient;
import cn.ucloud.ufile.api.object.ObjectConfig;
import cn.ucloud.ufile.auth.ObjectAuthorization;
import cn.ucloud.ufile.auth.UfileObjectLocalAuthorization;
import cn.ucloud.ufile.bean.PutObjectResultBean;
import cn.ucloud.ufile.exception.UfileClientException;
import cn.ucloud.ufile.exception.UfileServerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

@Service
public class UCloudProvider {
    @Value("${ucloud.ufile.public-key}")
    private String publicKey;
    @Value("${ucloud.ufile.private-key}")
    private String privateKey;

    @Value("${ucloud.ufile.buckt-name}")
    private String bucket;

    @Value("${ucloud.ufile.region}")
    private String region;

    @Value("${ucloud.ufile.suffix}")
    private String suffix;


    public String upload(InputStream inputStream,String mimeType,String fileName){

        String generateFileName="";
        System.out.println(fileName);
        String[] fileSpliter = fileName.split("\\.");
        if(fileSpliter.length>1){
            generateFileName = UUID.randomUUID().toString()+"."+fileSpliter[fileSpliter.length-1];
        }else {
           // throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }

        try {
            ObjectAuthorization objectAuthorization = new UfileObjectLocalAuthorization(publicKey,privateKey);
            ObjectConfig config = new ObjectConfig(region, suffix);

            PutObjectResultBean response = UfileClient.object(objectAuthorization, config)
                    .putObject(inputStream,mimeType)
                    .nameAs(generateFileName)
                    .toBucket(bucket)
                    .setOnProgressListener((bytesWritten, contentLength) -> {
                    })
                    .execute();

            if(response != null && response.getRetCode() == 0){
                String url = UfileClient.object(objectAuthorization,config)
                        .getDownloadUrlFromPrivateBucket(generateFileName,bucket,24*60*60*365)
                        .createUrl();
                return url;
            }else{
                //throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
            }

        } catch (UfileClientException e) {
            e.printStackTrace();
           // throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        } catch (UfileServerException e) {
            e.printStackTrace();
            //throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
        return null;
    }
}
