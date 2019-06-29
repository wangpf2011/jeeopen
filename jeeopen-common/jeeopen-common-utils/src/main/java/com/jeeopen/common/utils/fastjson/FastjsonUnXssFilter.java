package com.jeeopen.common.utils.fastjson;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package cn.gov.gzst.common.filter.xss
 * @title:
 * @description: Fastjson中，对返回值的处理
* @author: wangpf
 * @date: 2018/4/24 15:14
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public class FastjsonUnXssFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        // 判断如果是字符串反解析
        if (value instanceof  String && value != null){
            return StringEscapeUtils.unescapeHtml4(value+"");
        }
        return value;
    }
}
