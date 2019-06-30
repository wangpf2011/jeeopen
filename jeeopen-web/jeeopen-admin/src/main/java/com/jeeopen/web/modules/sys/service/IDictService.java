package com.jeeopen.web.modules.sys.service;


import java.util.List;

import com.jeeopen.web.modules.sys.entity.Dict;
import com.jeeopen.common.mybatis.mvc.service.ICommonService;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2017-02-09 09:05:29
 * @version V1.0
 *
 */
public interface IDictService extends ICommonService<Dict> {
    public List<Dict> selectDictList();
}
