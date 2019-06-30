package com.jeeopen.web.beetltags;

import org.beetl.core.BodyContent;
import org.beetl.core.GeneralVarTagBinding;
import org.beetl.core.exception.BeetlException;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.beetltags
 * @title:
 * @description: BodyTag
* @author: wangpf
 * @date: 2018/8/8 14:44
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public interface BodyTag {

    int EVAL_BODY_BUFFERED = 2;

    void setBodyContent(BodyContent bodyContent);

    void doInitBody() throws BeetlException;
}