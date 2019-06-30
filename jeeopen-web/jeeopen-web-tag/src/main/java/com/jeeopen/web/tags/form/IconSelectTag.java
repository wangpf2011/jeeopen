package com.jeeopen.web.tags.form;

import java.util.HashMap;
import java.util.Map;

import com.jeeopen.web.tags.form.support.FreemarkerFormTagHelper;
import com.jeeopen.web.tags.html.manager.HtmlComponentManager;
import com.jeeopen.web.beetltags.annotation.BeetlTagName;
import com.jeeopen.web.beetltags.exception.BeetlTagException;
import com.jeeopen.web.beetltags.form.HiddenInputTag;
import com.jeeopen.web.beetltags.form.TagWriter;
import com.jeeopen.common.utils.SpringContextHolder;
import com.jeeopen.common.utils.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: TreeSelect.java
 * @package com.jeeopen.tags.form
 * @description: 图标选择
* @author: wangpf
 * @date: 2017年4月10日 下午9:16:24
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
@Component
@Scope("prototype")
@BeetlTagName("form.iconselect")
public class IconSelectTag extends HiddenInputTag {
	private String width = "800px";// 宽度
	private String height = "420px";// 高度
	private Boolean genField = Boolean.TRUE;// 是否生成,显示域
	private String viewUrl="/admin/common/icons";//视图Url
	private String callback = "";// 回调函数

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		tagWriter.startTag("input");
		writeDefaultAttributes(tagWriter);
		tagWriter.writeAttribute("type", "hidden");
		if (isDisabled()) {
			tagWriter.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
		}
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		tagWriter.writeAttribute("value", processFieldValue(getName(), value, "hidden"));
		tagWriter.endTag();
		// 输出编辑器代码片段
		writeFragment(tagWriter);
		return SKIP_BODY;
	}

	private void writeFragment(TagWriter tagWriter) throws BeetlTagException {
		Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, this.ctx);
		rootMap.put("name", getPath());
		rootMap.put("genField", genField);
		rootMap.put("width", width);
		rootMap.put("viewUrl",viewUrl);
		rootMap.put("height", height);
		rootMap.put("callback", callback);
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		rootMap.put("value", processFieldValue(getName(), value, "hidden"));
		HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
				.getBean(HtmlComponentManager.class);
		String fragment = htmlComponentManager.getFragmentComponent("fa-icons", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			tagWriter.forceAppendValue(fragment);
		}
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getViewUrl() {
		return viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public Boolean getGenField() {
		return genField;
	}

	public void setGenField(Boolean genField) {
		this.genField = genField;
	}
	
	
}
