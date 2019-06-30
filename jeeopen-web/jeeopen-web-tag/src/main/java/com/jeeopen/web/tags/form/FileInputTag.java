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
import com.jeeopen.common.utils.*;
import com.jeeopen.web.beetltags.form.TagWriter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: FileInputTag.java
 * @package com.jeeopen.tags.form
 * @description: http://plugins.krajee.com/file-avatar-upload-demo#avatar-upload
 *               -1 文档
* @author: wangpf
 * @date: 2017年5月24日 上午8:58:15
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
@Component
@Scope("prototype")
@BeetlTagName("form.fileinput")
public class FileInputTag extends HiddenInputTag {
	protected String fileInputType = "fileinput"; // 文本上传类型
	protected Boolean multiple = Boolean.TRUE;// 是否多文件上传
	protected String uploadUrl = "";// 文件上传的URL路径
	protected String deleteUrl = "";// 删除URL
	protected String initUrl = "";// 初始化的URL
	protected String uploadExtraData = "{}";// 参数名称的扩展参数
	protected String uploadExtraFieldData = "";// 参数名称的扩展参数名称,多个逗号隔开
	protected String extend = "";// 接收的文件后缀
	protected String buttonText = "选择文件";// 按钮文本
	protected String fileInputSetting = "{}"; // JS格式
	protected String fileInputSettingCallback = ""; // 配置方法,为js方法，返回配置
	protected String uploadSuccessCallback = ""; // 上传成功回调
	protected String refreshCallback = "";// 刷新数据的时候回调
	protected Boolean showCaption = Boolean.FALSE; // 是否显示标题
	protected Boolean dropZoneEnabled = Boolean.FALSE;
	protected Boolean autoUpload = null; // 是否自动上传
	protected int maxFileCount = 10;
	protected String theme = ""; // 样式
	protected String saveType = "id"; // 默认id为ID,filepath,为路径
	protected String showType = "file";// 是否多文件上传,file,avatar
	protected String idField = "id";
	protected String filepathField = "filePath";
	protected String fileInputWidth = "100%";
	protected String fileInputHeight = "100%";
	protected String basePath = "";//文件业务目录


	public String getFileInputType() {
		return fileInputType;
	}

	public void setFileInputType(String fileInputType) {
		this.fileInputType = fileInputType;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public String getFileInputSetting() {
		return fileInputSetting;
	}

	public void setFileInputSetting(String fileInputSetting) {
		this.fileInputSetting = fileInputSetting;
	}

	public String getFileInputSettingCallback() {
		return fileInputSettingCallback;
	}

	public void setFileInputSettingCallback(String fileInputSettingCallback) {
		this.fileInputSettingCallback = fileInputSettingCallback;
	}

	public Boolean getDropZoneEnabled() {
		return dropZoneEnabled;
	}

	public void setDropZoneEnabled(Boolean dropZoneEnabled) {
		this.dropZoneEnabled = dropZoneEnabled;
	}

	public int getMaxFileCount() {
		return maxFileCount;
	}

	public void setMaxFileCount(int maxFileCount) {
		this.maxFileCount = maxFileCount;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getInitUrl() {
		return initUrl;
	}

	public void setInitUrl(String initUrl) {
		this.initUrl = initUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	public String getUploadExtraData() {
		return uploadExtraData;
	}

	public void setUploadExtraData(String uploadExtraData) {
		this.uploadExtraData = uploadExtraData;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public Boolean getAutoUpload() {
		return autoUpload;
	}

	public void setAutoUpload(Boolean autoUpload) {
		this.autoUpload = autoUpload;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getUploadExtraFieldData() {
		return uploadExtraFieldData;
	}

	public void setUploadExtraFieldData(String uploadExtraFieldData) {
		this.uploadExtraFieldData = uploadExtraFieldData;
	}

	public String getUploadSuccessCallback() {
		return uploadSuccessCallback;
	}

	public void setUploadSuccessCallback(String uploadSuccessCallback) {
		this.uploadSuccessCallback = uploadSuccessCallback;
	}

	public String getRefreshCallback() {
		return refreshCallback;
	}

	public void setRefreshCallback(String refreshCallback) {
		this.refreshCallback = refreshCallback;
	}

	public Boolean getShowCaption() {
		return showCaption;
	}

	public void setShowCaption(Boolean showCaption) {
		this.showCaption = showCaption;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getIdField() {
		return idField;
	}

	public void setIdField(String idField) {
		this.idField = idField;
	}

	public String getFilepathField() {
		return filepathField;
	}

	public void setFilepathField(String filepathField) {
		this.filepathField = filepathField;
	}

	public String getFileInputWidth() {
		return fileInputWidth;
	}

	public void setFileInputWidth(String fileInputWidth) {
		this.fileInputWidth = fileInputWidth;
	}

	public String getFileInputHeight() {
		return fileInputHeight;
	}

	public void setFileInputHeight(String fileInputHeight) {
		this.fileInputHeight = fileInputHeight;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
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
		if (showType.equals("avatar")) {
			if (StringUtils.isEmpty(extend)) {
				extend = "jpg,png,gif";
			}
			if (autoUpload == null) {
				autoUpload = Boolean.TRUE;
			}
			this.saveType = "filepath";

		}
		if (autoUpload == null) {
			autoUpload = Boolean.FALSE;
		}
		//文件上传
		Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, this.ctx);
		rootMap.put("uploadUrl", uploadUrl);
		rootMap.put("deleteUrl", deleteUrl);
		rootMap.put("initUrl", initUrl);
		rootMap.put("multiple", multiple);
		rootMap.put("buttonText", buttonText);
		rootMap.put("uploadExtraData", uploadExtraData);
		rootMap.put("uploadExtraFieldData", uploadExtraFieldData);
		rootMap.put("path", resolveId());
		rootMap.put("refreshCallback", refreshCallback);
		rootMap.put("dropZoneEnabled", dropZoneEnabled);
		rootMap.put("maxFileCount", maxFileCount);
		rootMap.put("theme", theme);
		rootMap.put("autoUpload", autoUpload);
		rootMap.put("saveType", saveType);
		rootMap.put("idField", idField);
		rootMap.put("filepathField", filepathField);
		rootMap.put("fileInputWidth", fileInputWidth);
		rootMap.put("fileInputHeight", fileInputHeight);
		rootMap.put("basePath",basePath);
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		rootMap.put("value", processFieldValue(getName(), value, "hidden"));
		if (StringUtils.isEmpty(extend)) {
			// extend = propertiesUtil.getString("upload.allowed.extension");
		}
		// 处理extend 加入引号
		String[] extendStrs = extend.split(",");
		List<String> extendList = new ArrayList<String>();
		for (String extendIn : extendStrs) {
			extendList.add(extendIn.trim());
		}
		String extendStr = "'" + StringUtils.join(extendList, "','") + "'";
		rootMap.put("extend", extendStr);
		rootMap.put("buttonText", buttonText);
		rootMap.put("fileInputSetting", fileInputSetting);
		rootMap.put("showCaption", showCaption);
		rootMap.put("fileInputSettingCallback", fileInputSettingCallback);
		rootMap.put("uploadSuccessCallback", uploadSuccessCallback);
		rootMap.put("showType", showType);
		HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
				.getBean(HtmlComponentManager.class);
		String fragment = htmlComponentManager.getFragmentComponent(getComponentKey(), rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			tagWriter.forceAppendValue(fragment);
		}
	}

	private String getComponentKey() {
		/*
		 * if (showType.equals("avatar")) { return fileInputType + "-avatar"; }
		 */
		return fileInputType + "-file";
	}

}
