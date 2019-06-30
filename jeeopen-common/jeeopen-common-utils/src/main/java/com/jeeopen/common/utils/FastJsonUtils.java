package com.jeeopen.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.jeeopen.common.utils.fastjson.FastjsonPropertyPreFilter;
import com.jeeopen.common.utils.fastjson.FastjsonUnXssFilter;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package com.jeeopen.common.utils
 * @title:
 * @description: 打印json
 * @author: wangpf
 * @date: 2018/10/30 11:04
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class FastJsonUtils {

    public static void print(Object object,Class<?> clazz,String includesProperties){
        FastjsonPropertyPreFilter fastjsonPropertyPreFilter = new FastjsonPropertyPreFilter(clazz,includesProperties);
        FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
        SerializeFilter[] filters={fastjsonPropertyPreFilter,fastjsonUnXssFilter};
        String content = JSON.toJSONString(object,filters);
        StringUtils.printJson(ServletUtils.getResponse(),content);
    }

    public static void print(Object object,String includesProperties){
        FastjsonPropertyPreFilter fastjsonPropertyPreFilter = new FastjsonPropertyPreFilter(object.getClass(),includesProperties);
        FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
        SerializeFilter[] filters={fastjsonPropertyPreFilter,fastjsonUnXssFilter};
        String content = JSON.toJSONString(object,filters);
        StringUtils.printJson(ServletUtils.getResponse(),content);
    }

    public static void print(Object object){
        FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
        String content = JSON.toJSONString(object,fastjsonUnXssFilter);
        StringUtils.printJson(ServletUtils.getResponse(),content);
    }
}
