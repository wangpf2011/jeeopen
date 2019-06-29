package com.jeeopen.common.utils.convert;

import org.springframework.util.StringUtils;

import com.jeeopen.common.utils.DateUtils;

import java.beans.PropertyEditorSupport;

/**
 * 时间处理类
 * 
 * @author wangpf
 * @date 2016-12-21
 * @version V 1.0
 */
public class DateConvertEditor extends PropertyEditorSupport {

	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text)) {
			try {
				setValue(DateUtils.parseDate(text));
			} catch (Exception ex) {
				IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		} else {
			setValue(null);
		}
	}
}
