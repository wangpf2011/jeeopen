package com.jeeopen.common.mvc.controller;

import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.jeeopen.common.mvc.exception.ValidationException;
import com.jeeopen.common.utils.MessageUtils;
import com.jeeopen.common.utils.ReflectionUtils;
import com.jeeopen.common.utils.StringUtils;

import java.io.Serializable;
import java.util.List;

public abstract class BaseBeanController<Entity extends Serializable> extends BaseController {

	/**
	 * 实体类型
	 */
	protected final Class<Entity> entityClass;

	protected BaseBeanController() {
		this.entityClass = ReflectionUtils.getSuperGenericType(getClass());
	}

	protected Entity newModel() {
		try {
			return entityClass.newInstance();
		} catch (Exception e) {
			throw new IllegalStateException("can not instantiated model : " + this.entityClass, e);
		}
	}

	/**
	 * 共享的验证规则 验证失败返回true
	 *
	 * @param entity
	 * @param result
	 * @return
	 */
	protected boolean hasError(Entity entity, BindingResult result) {
		Assert.notNull(entity);
		return result.hasErrors();
	}

	protected void checkError(Entity entity, BindingResult result) {
		if (hasError(entity, result)) {
			// 错误提示
			String errorMsg = errorMsg(result);
			if (!StringUtils.isEmpty(errorMsg)) {
				throw new ValidationException(errorMsg);
			} else {
				throw new ValidationException("验证失败");
			}
		}
	}

	/**
	 * 
	 * @title: errorMsg
	 * @description: 错误信息组装
	 * @param result
	 * @return
	 * @return: String
	 */
	protected String errorMsg(BindingResult result) {
		String errorMsg = "";
		if (result.getErrorCount() > 0) {
			List<ObjectError> objectErrorList = result.getAllErrors();
			for (ObjectError objectError : objectErrorList) {
				String message = MessageUtils.getMessage(objectError.getCode(), objectError.getDefaultMessage(),
						objectError.getArguments());
				if (!StringUtils.isEmpty(message)) {
					errorMsg = errorMsg + message + "<br />";
				}
			}
		}
		return errorMsg;
	}

	/**
	 * @param backURL
	 *            null 将重定向到默认getViewPrefix()
	 * @return
	 */
	protected String redirectToUrl(String backURL) {
		if (StringUtils.isEmpty(backURL)) {
			backURL = getViewPrefix();
		}
		if (!backURL.startsWith("/") && !backURL.startsWith("http")) {
			backURL = "/" + backURL;
		}
		return "redirect:" + backURL;
	}

}
