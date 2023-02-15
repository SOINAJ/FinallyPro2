package com.finallypro2.util;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;

public class MyBos {
    private String ACCESS_KEY_ID = "11e6e918c692468ea1785d2d003c7807";
    private String SECRET_ACCESS_KEY ="3f2e5906cb2941b7b4d23130a165c94b";
    private String ENDPOINT = "gz.bcebos.com";

    public BosClient getBosClient(){
        BosClientConfiguration configuration = new BosClientConfiguration();
        configuration.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID,SECRET_ACCESS_KEY));
        configuration.setEndpoint(ENDPOINT);
        return new BosClient(configuration);
    }
}
