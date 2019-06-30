package com.jeeopen.web.beetltags.form;

import com.jeeopen.web.beetltags.exception.BeetlTagException;

public abstract class AbstractHtmlInputElementTag extends AbstractHtmlElementTag {

	/**
	 * The name of the '{@code onfocus}' attribute.
	 */
	public static final String ONFOCUS_ATTRIBUTE = "onfocus";

	/**
	 * The name of the '{@code onblur}' attribute.
	 */
	public static final String ONBLUR_ATTRIBUTE = "onblur";

	/**
	 * The name of the '{@code onchange}' attribute.
	 */
	public static final String ONCHANGE_ATTRIBUTE = "onchange";

	/**
	 * The name of the '{@code accesskey}' attribute.
	 */
	public static final String ACCESSKEY_ATTRIBUTE = "accesskey";

	/**
	 * The name of the '{@code disabled}' attribute.
	 */
	public static final String DISABLED_ATTRIBUTE = "disabled";

	/**
	 * The name of the '{@code readonly}' attribute.
	 */
	public static final String READONLY_ATTRIBUTE = "readonly";


	private String onfocus;

	private String onblur;

	private String onchange;

	private String accesskey;

	private boolean disabled;

	private boolean readonly;


	/**
	 * Set the value of the '{@code onfocus}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	/**
	 * Get the value of the '{@code onfocus}' attribute.
	 */
	protected String getOnfocus() {
		return this.onfocus;
	}

	/**
	 * Set the value of the '{@code onblur}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	/**
	 * Get the value of the '{@code onblur}' attribute.
	 */
	protected String getOnblur() {
		return this.onblur;
	}

	/**
	 * Set the value of the '{@code onchange}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	/**
	 * Get the value of the '{@code onchange}' attribute.
	 */
	protected String getOnchange() {
		return this.onchange;
	}

	/**
	 * Set the value of the '{@code accesskey}' attribute.
	 * May be a runtime expression.
	 */
	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	/**
	 * Get the value of the '{@code accesskey}' attribute.
	 */
	protected String getAccesskey() {
		return this.accesskey;
	}

	/**
	 * Set the value of the '{@code disabled}' attribute.
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * Get the value of the '{@code disabled}' attribute.
	 */
	protected boolean isDisabled() {
		return this.disabled;
	}

	/**
	 * Sets the value of the '{@code readonly}' attribute.
	 */
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	/**
	 * Gets the value of the '{@code readonly}' attribute.
	 */
	protected boolean isReadonly() {
		return this.readonly;
	}


	/**
	 * Adds input-specific optional attributes as defined by this base class.
	 */
	@Override
	protected void writeOptionalAttributes(TagWriter tagWriter) throws BeetlTagException {
		super.writeOptionalAttributes(tagWriter);

		writeOptionalAttribute(tagWriter, ONFOCUS_ATTRIBUTE, getOnfocus());
		writeOptionalAttribute(tagWriter, ONBLUR_ATTRIBUTE, getOnblur());
		writeOptionalAttribute(tagWriter, ONCHANGE_ATTRIBUTE, getOnchange());
		writeOptionalAttribute(tagWriter, ACCESSKEY_ATTRIBUTE, getAccesskey());
		if (isDisabled()) {
			tagWriter.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
		}
		if (isReadonly()) {
			writeOptionalAttribute(tagWriter, READONLY_ATTRIBUTE, "readonly");
		}
	}

}
