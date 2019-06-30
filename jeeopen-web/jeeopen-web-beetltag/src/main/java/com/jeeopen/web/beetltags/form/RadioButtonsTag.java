package com.jeeopen.web.beetltags.form;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jeeopen.web.beetltags.annotation.BeetlTagName;

@Component
@Scope("prototype")
@BeetlTagName("form.radiobuttons")
public class RadioButtonsTag extends AbstractMultiCheckedElementTag {

	@Override
	protected String getInputType() {
		return "radio";
	}

}
