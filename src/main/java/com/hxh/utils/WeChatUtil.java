package com.hxh.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @auth hxh
 * @date 2020/6/30 16:59
 * @Description
 */
public class WeChatUtil {
    public JSONObject auth(String url) {

        try {
            // 创建一个http Client请求
            CloseableHttpClient client = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(url);

            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();       // 获取响应数据(json)

            if (entity != null) {
                String result = EntityUtils.toString(entity, Charset.forName("UTF8"));

                return JSONObject.parseObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public JSONObject getUserInfo(String url) {

        try {
            CloseableHttpClient client = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(url);

            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity, Charset.forName("UTF8"));

                return JSONObject.parseObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
