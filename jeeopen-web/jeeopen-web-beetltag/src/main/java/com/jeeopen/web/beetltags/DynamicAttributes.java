package com.jeeopen.web.beetltags;

import com.jeeopen.web.beetltags.exception.BeetlTagException;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.beetltags
 * @title:
 * @description: 动态数据整理
* @author: wangpf
 * @date: 2018/8/8 19:29
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public interface DynamicAttributes {
    void setDynamicAttribute(String localName, Object value) throws BeetlTagException;
}
