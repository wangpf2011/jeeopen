package com.jeeopen.common.sms.client;

import com.alibaba.fastjson.JSON;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.jeeopen.common.sms.config.SmsConfigProperties;
import com.jeeopen.common.sms.data.SmsResult;

import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By kjt.gzst.gov.cn
 *
 * @version V1.0
 * @title: IOSSClient.java
 * @description: 腾讯客户端操作
* @author: wangpf
 * @date: 2017年8月11日 下午9:55:00
 * @copyright: 2017 kjt.gzst.gov.cn Inc. All rights reserved.
 */
public class TencentSmsClient implements ISmsClient {
    //是否开启
    private Boolean isOpen;
    //签名
    private String signName;

    private SmsConfigProperties smsConfigProperties;

    // 短信应用SDK AppID
    private  Integer appId= 0;
    // 短信应用SDK AppKey
    private  String appKey="";

    @Override
    public void init(SmsConfigProperties smsConfigProperties) {
        this.smsConfigProperties = smsConfigProperties;
        isOpen=this.smsConfigProperties.getOpen();
        signName=this.smsConfigProperties.getSignName();
        appId = this.smsConfigProperties.getTencent().getAppId();
        appKey = this.smsConfigProperties.getTencent().getAppKey();
    }

    @Override
    public SmsResult send(String phone, String template) {
        Map<String, Object> datas = new HashMap<>();
        return send(phone,template,datas);
    }

    @Override
    public SmsResult send(String phone, String template, Map<String, Object> datas) {
        if (!isOpen){
            return SmsResult.success("测试成功");
        }
        SmsResult smsResult = new SmsResult();
        try {
            SmsSingleSender msender = new SmsSingleSender(appId, appKey);
            SmsSingleSenderResult result =  msender.sendWithParam("86", phone,
                    Integer.parseInt(template), mapToList(datas), signName,"","");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            if (result.result == 0)
            {
                smsResult = SmsResult.success(result.errMsg);
            }else{
                smsResult = SmsResult.fail(result.errMsg);
            }
            smsResult.setSmsid(result.sid);
            smsResult.setReponseData(JSON.toJSONString(result));
        }catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
            smsResult = SmsResult.fail("HTTP响应码错误");
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
            smsResult = SmsResult.fail("json解析错误");
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
            smsResult = SmsResult.fail("网络IO错误");
        } catch (Exception e) {
            smsResult = SmsResult.fail(e.getMessage());
        }
        return smsResult;
    }

    public ArrayList<String> mapToList(Map<String,Object> datas){
        ArrayList<String> dataList= new ArrayList<>();
        for (Object object : datas.entrySet()) {
            dataList.add(String.valueOf(object));
        }
        return dataList;
    }
}
