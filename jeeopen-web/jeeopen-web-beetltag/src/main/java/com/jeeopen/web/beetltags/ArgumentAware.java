package com.jeeopen.web.beetltags;

import org.springframework.lang.Nullable;

import com.jeeopen.web.beetltags.exception.BeetlTagException;

public interface ArgumentAware {

	/**
	 * Callback hook for nested spring:argument tags to pass their value
	 * to the parent tag.
	 * @param argument the result of the nested {@code spring:argument} tag
	 */
	void addArgument(@Nullable Object argument) throws BeetlTagException;

}
