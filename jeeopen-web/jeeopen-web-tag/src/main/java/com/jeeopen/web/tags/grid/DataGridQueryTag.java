package com.jeeopen.web.tags.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeeopen.web.tags.tag.AbstractGridHtmlTag;
import com.jeeopen.web.beetltags.annotation.BeetlTagName;
import com.jeeopen.web.beetltags.dict.Dict;
import com.jeeopen.web.beetltags.dict.DictUtils;
import com.jeeopen.web.beetltags.exception.BeetlTagException;
import com.jeeopen.common.utils.MessageUtils;
import com.jeeopen.common.utils.ObjectUtils;
import com.jeeopen.common.utils.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @Title: DataGridColumnTag.java
 * @Package com.jeeopen.tags.grid
 * @Description: 查询
* @author: wangpf
 * @date: 2017年3月4日 下午9:03:39
 * @version V1.0
 * @Copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
@Component
@Scope("prototype")
@BeetlTagName("grid.query")
public class DataGridQueryTag extends AbstractGridHtmlTag {
	private String label;// 标题文字
	private String name;// 列字段名称
	private String queryMode = "input";// 默认为input，有dict时候，默认为select
	private String condition = "eq";// 查询方式
	private String dict;// 字典类型

	private Map<String, Object> queryStaticAttributes;
	private Map<String, Object> queryDynamicAttributes;
	private DataGridTag parentTag = null;

	public int doEndTag() throws BeetlTagException {
		parentTag = (DataGridTag)this.ctx.globalVar.get(PARENT_VARIABLE_NAME);
		this.label = MessageUtils.getMessageOrSelf(label);
		addQuery();
		return EVAL_PAGE;
	}

	private void addQuery() {
		// 初始化数据

		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name", name);
		queryMap.put("label", label);
		if (!StringUtils.isEmpty(dict)) {
			queryMap.put("dict", dict);
		}
		queryMap.put("queryMode", queryMode);
		queryMap.put("condition", condition);
		if (queryDynamicAttributes != null) {
			queryMap.putAll(queryDynamicAttributes);
		}
		if (queryStaticAttributes != null) {
			queryMap.putAll(queryStaticAttributes);
		}
		if (!queryMap.containsKey("class")) {
			queryMap.put("class", "form-control");
		}
		if (queryMode.equals("radio") || queryMode.equals("checkbox")) {
			queryMap.put("class", queryMap.get("class") + " i-checks");
		}
		parentTag.addQuery(queryMap);

	}

	public String dictToFormatterValue(String dict) {
		String dictStr = "";
		List<Dict> dictList = DictUtils.getDictList(dict);
		for (Dict dictEntity : dictList) {
			if (!StringUtils.isEmpty(dictStr)) {
				dictStr += ";";
			}
			dictStr += dictEntity.getValue() + ":" + dictEntity.getLabel();
		}
		return dictStr;
	}

	@Override
	public void setStaticAttribute(String localName, Object value) throws BeetlTagException {
		if (this.staticAttributes == null) {
			this.staticAttributes = new HashMap<String, Object>();
		}
		if (this.queryStaticAttributes == null) {
			this.queryStaticAttributes = new HashMap<String, Object>();
		}
		if (!ObjectUtils.isNullOrEmpty(value)) {
			if (localName.equals("query")) {// 不处理
				return;
			} else if (localName.equals("condition") || localName.startsWith("query_")) {// query参数
				localName = localName.replace("query_", localName);// 去掉前缀
				queryStaticAttributes.put(localName, value);
			} else {
				staticAttributes.put(localName, value);
			}
		}
		if (localName.equals("label")) {
			staticAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}
	}

	@Override
	public void setDynamicAttribute(String localName, Object value) throws BeetlTagException {
		if (this.dynamicAttributes == null) {
			this.dynamicAttributes = new HashMap<String, Object>();
		}
		if (this.queryDynamicAttributes == null) {
			this.queryDynamicAttributes = new HashMap<String, Object>();
		}

		if (localName.equals("condition") || localName.startsWith("query_")) {// query参数
			localName = localName.replace("query_", "");// 去掉前缀
			queryDynamicAttributes.put(localName, value);
		} else {
			dynamicAttributes.put(localName, value);
		}
		if (localName.equals("label")) {
			dynamicAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	public String getQueryMode() {
		return queryMode;
	}

	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

}