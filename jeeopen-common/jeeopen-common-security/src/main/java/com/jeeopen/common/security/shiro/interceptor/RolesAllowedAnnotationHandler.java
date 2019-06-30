package com.jeeopen.common.security.shiro.interceptor;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;

import com.jeeopen.common.security.shiro.authz.annotation.RolesAllowed;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * 拦截器
 * 
 * @author wangpf
 *
 */
public class RolesAllowedAnnotationHandler extends AuthorizingAnnotationHandler {

	/**
	 * 构造函数
	 *
	 */
	public RolesAllowedAnnotationHandler() {
		super(RolesAllowed.class);
	}

	@Override
	public void assertAuthorized(Annotation a) throws AuthorizationException {
		RolesAllowed rrAnnotation = (RolesAllowed) a;
		String[] roles = rrAnnotation.value();
		getSubject().checkRoles(Arrays.asList(roles));
		return;
	}

}