package com.jeeopen.common.query.data;

import com.alibaba.fastjson.serializer.SerializeFilter;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: PropertyPreFilterable.java
 * @package com.jeeopen.common.query.data
 * @description: JSON格式化输出
 * @author: wangpf
 * @date: 2017年5月1日 下午9:43:09
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public interface PropertyPreFilterable {
	
	public SerializeFilter constructFilter(Class<?> clazz);
	
	public void addQueryProperty(String... properties);
	
	public void addIncludeFilter(Class<?> clazz, String... properties);

	public void addExcludeFilter(Class<?> clazz, String... properties);
}
