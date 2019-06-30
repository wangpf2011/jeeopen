package com.jeeopen.web.modules.sys.service;

import java.util.List;

import com.jeeopen.web.modules.sys.entity.Role;
import com.jeeopen.common.mybatis.mvc.service.ICommonService;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:15
 * @version V1.0
 *
 */
public interface IRoleService extends ICommonService<Role> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Role> findListByUserId(String userid);
}
