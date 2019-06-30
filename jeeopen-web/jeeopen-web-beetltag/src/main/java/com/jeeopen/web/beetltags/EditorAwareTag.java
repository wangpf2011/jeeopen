package com.jeeopen.web.beetltags;

import java.beans.PropertyEditor;

import org.springframework.lang.Nullable;

import com.jeeopen.web.beetltags.exception.BeetlTagException;

public interface EditorAwareTag {

	/**
	 * Retrieve the PropertyEditor for the property that this tag is
	 * currently bound to. Intended for cooperating nesting tags.
	 * @return the current PropertyEditor, or {@code null} if none
	 * @throws BeetlTagException if resolving the editor failed
	 */
	@Nullable
	PropertyEditor getEditor() throws BeetlTagException;

}
