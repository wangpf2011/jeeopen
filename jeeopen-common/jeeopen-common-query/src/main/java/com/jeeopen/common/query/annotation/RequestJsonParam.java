package com.jeeopen.common.query.annotation;

import java.lang.annotation.*;

/**
 * 
 * 该注解用于绑定请求参数（JSON字符串）
 * 
 * @author Zhang Kaitao
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJsonParam {

	/**
	 * 用于绑定的请求参数名字
	 */
	String value() default "";
	
	/**
	 * 是否必须，默认是
	 */
	boolean required() default true;

}
