package com.jeeopen.web.aspectj.annotation;

import java.lang.annotation.*;

import com.jeeopen.web.aspectj.enums.LogType;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.aspectj
 * @title:
 * @description: 自定义操作日志记录注解
 * @author: wangpf
 * @date: 2018/8/7 11:31
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /** 标题或模块 */
    String title() default "";

    /** 功能 */
    LogType logType() default LogType.OTHER;

    /** 请求参数 */
    boolean requestParam() default true;

}
