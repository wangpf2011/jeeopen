package com.jeeopen.common.oss.client;

import com.jeeopen.common.utils.PropertiesUtil;
import com.jeeopen.common.utils.ServletUtils;

import com.aliyun.oss.OSSClient;
import com.jeeopen.common.oss.config.AliyunConfig;
import com.jeeopen.common.oss.config.LocalConfig;
import com.jeeopen.common.oss.config.OssConfig;
import com.jeeopen.common.oss.exception.OSSException;

import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * All rights Reserved, Designed By kjt.gzst.gov.cn
 *
 * @version V1.0
 * @title: IOSSClient.java
 * @description: 这里为本地操作
* @author: wangpf
 * @date: 2017年8月11日 下午9:55:00
 * @copyright: 2017 kjt.gzst.gov.cn Inc. All rights reserved.
 */
public class LocalClient extends  AbstractOSSClient {

    public static final String DEFAULT_CONFIG_FILE = "local.properties";
    private String domain;//本地域名配置
    private String uploadFilePath;//上传路径

    @Override
    public void init() {
      init(DEFAULT_CONFIG_FILE);
    }

    @Override
    public void init(String propertiesName) {
        PropertiesUtil p = new PropertiesUtil(propertiesName);
        domain = p.getString("local.domain");
        uploadFilePath = p.getString("local.upload-file-path");

    }

    @Override
    public void init(OssConfig config) {
        LocalConfig localConfig = config.getLocal();
        domain = localConfig.getDomain();
        uploadFilePath = localConfig.getUploadFilePath();
    }


    /**
     * 判断文件地址保存文件
     * @param path
     * @return
     * @throws IOException
     */
    private File getAbsoluteFile(String path) throws IOException {
        String basePath = uploadFilePath;
        File desc = new File(basePath+File.separator+path);
        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

    /**
     * 文件上传
     * @param inputStream
     * @param path
     * @return
     */
    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            File outFile=getAbsoluteFile(path);
            FileUtils.copyInputStreamToFile(inputStream,outFile);
        } catch (Exception e) {
            throw new OSSException("上传文件失败", e);
        }
        return domain + "/" + path;
    }

    @Override
    public void delete(String filename) {
        String basePath=uploadFilePath;
        File desc = new File(basePath+File.pathSeparator+filename);
        if (desc.exists()) {
            desc.delete();
        }
    }

}
