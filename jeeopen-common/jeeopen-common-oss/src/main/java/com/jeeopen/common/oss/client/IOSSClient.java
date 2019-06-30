package com.jeeopen.common.oss.client;

import java.io.InputStream;

import com.jeeopen.common.oss.config.OssConfig;

/**
 * All rights Reserved, Designed By kjt.gzst.gov.cn
 *
 * @version V1.0
 * @title: IOSSClient.java
 * @description: 常量
 * @author: wangpf
 * @date: 2017年8月11日 下午9:55:00
 * @copyright: 2017 kjt.gzst.gov.cn Inc. All rights reserved.
 */
//接口：插入、刪除、修改
//文件HTTP直接上传
//用一个虚类来处理公用的
//一个配置的地方，本系统默认采用阿里云，也就是云上贵州
public interface IOSSClient {

    /**
     * 客户端初始化
     */
    void init();

    /**
     * 客户端初始化
     * @param propertiesName
     */
    void init(String propertiesName);

    /**
     * 客户端初始化
     * @param config
     */
    void init(OssConfig config);

    /**
     * 文件上传
     *
     * @param inputStream
     * @param path
     * @return 返回可以访问的路径
     */
     String upload(InputStream inputStream, String path);

    /**
     * 删除文件
     * @param filename 文件的路径
     */
     void delete(String filename);
}
