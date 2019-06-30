package com.jeeopen.web.tags.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeeopen.web.tags.form.support.FreemarkerFormTagHelper;
import com.jeeopen.web.tags.html.manager.HtmlComponentManager;
import com.jeeopen.web.beetltags.annotation.BeetlTagName;
import com.jeeopen.web.beetltags.exception.BeetlTagException;
import com.jeeopen.web.beetltags.form.HiddenInputTag;
import com.jeeopen.web.beetltags.form.TagWriter;
import com.jeeopen.common.utils.SpringContextHolder;
import com.jeeopen.common.utils.StringUtils;
import com.jeeopen.common.utils.mapper.JsonMapper;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: TreeSelect.java
 * @package com.jeeopen.tags.form
 * @description: 树形选择
* @author: wangpf
 * @date: 2017年4月10日 下午9:16:24
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
@Component
@Scope("prototype")
@BeetlTagName("form.combox")
public class ComboxTag extends HiddenInputTag {
	private String labelName = "";// 显示域的ID
	private String labelValue = "";// 显示域的值
	private String idField = "id";/// 每组数据的哪个字段作为 data-id
	private String keyField = "name";// 每组数据的哪个字段作为输入框内容
	private Boolean multiWord = Boolean.FALSE;// 以分隔符号分割的多关键字支持
	private String separator = ",";// 多关键字支持时的分隔符，默认为空格
	private String getDataMethod = "";// 获取数据的方式，url：一直从url请求；data：从
										// options.data
										// 获取；firstByUrl：第一次从Url获取全部数据，之后从options.data获取
	private String effectiveFields = "";// 下拉要显示的列
	private String effectiveFieldsAlias = ""; // 有效字段的别名对象，用于 header 的显示
	private Boolean showHeader; // 是否显示头部
	private String dataUrl = "";// 获取数据的URL
	private String keyword="keyword";//搜索的关键字
	private Object datas;// 数据
	private String jsonp = ""; //
	private String processData = "";// 处理数据回调
	private String dataRequestSuccess = "";// 数据请求成功
	private String setSelectValue = "";// 设置选择数据回调
	private String unsetSelectValue = "";// 取消选择回调
	private String comboxSetting = ""; //扩展设置
	public String getIdField() {
		return idField;
	}

	public void setIdField(String idField) {
		this.idField = idField;
	}

	public String getKeyField() {
		return keyField;
	}

	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}

	public Boolean getMultiWord() {
		return multiWord;
	}

	public void setMultiWord(Boolean multiWord) {
		this.multiWord = multiWord;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getGetDataMethod() {
		return getDataMethod;
	}

	public void setGetDataMethod(String getDataMethod) {
		this.getDataMethod = getDataMethod;
	}

	public String getEffectiveFieldsAlias() {
		return effectiveFieldsAlias;
	}

	public void setEffectiveFieldsAlias(String effectiveFieldsAlias) {
		this.effectiveFieldsAlias = effectiveFieldsAlias;
	}

	public Boolean getShowHeader() {
		return showHeader;
	}

	public void setShowHeader(Boolean showHeader) {
		this.showHeader = showHeader;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public String getJsonp() {
		return jsonp;
	}

	public void setJsonp(String jsonp) {
		this.jsonp = jsonp;
	}

	public String getProcessData() {
		return processData;
	}

	public void setProcessData(String processData) {
		this.processData = processData;
	}

	public String getDataRequestSuccess() {
		return dataRequestSuccess;
	}

	public void setDataRequestSuccess(String dataRequestSuccess) {
		this.dataRequestSuccess = dataRequestSuccess;
	}

	public String getSetSelectValue() {
		return setSelectValue;
	}

	public void setSetSelectValue(String setSelectValue) {
		this.setSelectValue = setSelectValue;
	}

	public String getUnsetSelectValue() {
		return unsetSelectValue;
	}

	public void setUnsetSelectValue(String unsetSelectValue) {
		this.unsetSelectValue = unsetSelectValue;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}

	public String getEffectiveFields() {
		return effectiveFields;
	}

	public void setEffectiveFields(String effectiveFields) {
		this.effectiveFields = effectiveFields;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getComboxSetting() {
		return comboxSetting;
	}

	public void setComboxSetting(String comboxSetting) {
		this.comboxSetting = comboxSetting;
	}

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
		if (!StringUtils.isEmpty(effectiveFields)) {
			// 下拉要显示的列加入引号
			String[] effectiveFieldsArr = effectiveFields.split(",");
			List<String> effectiveFieldList = new ArrayList<String>();
			for (String effectiveField : effectiveFieldsArr) {
				effectiveFieldList.add(effectiveField.trim());
			}
			this.effectiveFields = JsonMapper.toJsonString(effectiveFieldList);
		}
		if (!StringUtils.isEmpty(effectiveFieldsAlias)) {
			Map<String, String> effectiveFieldsAliasMap = new HashMap<String, String>();
			String[] effectiveFieldsAliasArr = effectiveFieldsAlias.split(",");
			for (String effectiveFieldsAliasItem : effectiveFieldsAliasArr) {
				effectiveFieldsAliasItem = effectiveFieldsAliasItem.trim();
				String[] effectiveFieldsAliasItemArr = effectiveFieldsAliasItem.split("\\|");
				if (effectiveFieldsAliasItemArr.length == 2) {
					effectiveFieldsAliasMap.put(effectiveFieldsAliasItemArr[0], effectiveFieldsAliasItemArr[1]);
				}
			}
			if (effectiveFieldsAliasMap.size() > 0) {
				if (this.showHeader == null) {
					this.showHeader = Boolean.TRUE;
				}
			}
			this.effectiveFieldsAlias = JsonMapper.toJsonString(effectiveFieldsAliasMap);
		}
		Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, this.ctx);
		rootMap.put("name", getPath());
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		rootMap.put("value", processFieldValue(getName(), value, "hidden"));
		String initDatas = "[]";
		if (datas != null) {
			initDatas = JsonMapper.toJsonString(datas);
			if (StringUtils.isEmpty(getDataMethod)) {
				rootMap.put("getDataMethod", "data");
			}
		}
		if (!StringUtils.isEmpty(dataUrl)) {
			if (this.dataUrl.contains("?")) {
				this.dataUrl=this.dataUrl+"&"+keyword+"=";
			}else{
				this.dataUrl=this.dataUrl+"?"+keyword+"=";
			}
			if (StringUtils.isEmpty(getDataMethod)) {
				rootMap.put("getDataMethod", "url");
			}
			rootMap.put("dataUrl", dataUrl);
		}
		rootMap.put("labelName", getPath() + "Label");
		rootMap.put("labelValue", processFieldValue(getName(), value, "hidden"));
		rootMap.put("initDatas", initDatas);
		HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
				.getBean(HtmlComponentManager.class);
		String fragment = htmlComponentManager.getFragmentComponent("suggest-combox", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			tagWriter.forceAppendValue(fragment);
		}
	}
}
