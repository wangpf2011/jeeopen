package com.jeeopen.web.beetltags.dict;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @package  com.jeeopen.tags.utils
 * @title: 字典初始化接口
 * @description: 字典初始化
* @author: wangpf
 * @date: 2017/8/30 9:04
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public interface InitDictable {
    /**
     * 字典初始化
     * @return
     */
    public Map<String, List<Dict>> initDict();
}
