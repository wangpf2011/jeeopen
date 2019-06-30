package com.jeeopen.web.beetltags;


public interface ParamAware {

	/**
	 * Callback hook for nested spring:param tags to pass their value
	 * to the parent tag.
	 * @param param the result of the nested {@code spring:param} tag
	 */
	void addParam(Param param);

}
