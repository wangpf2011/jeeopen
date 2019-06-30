package com.jeeopen.web.beetltags.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.tags.annotation
 * @title:
 * @description: Beetl自定义标签命名
* @author: wangpf
 * @date: 2018/8/7 15:12
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BeetlTagName {
    /**
     * 标签名称
     */
    String value() default "";
}
