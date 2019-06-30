package com.jeeopen.web.modules.sys.service;

import java.util.List;

import com.jeeopen.web.modules.sys.entity.Organization;
import com.jeeopen.common.mybatis.mvc.service.ITreeCommonService;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:51
 * @version V1.0
 *
 */
public interface IOrganizationService extends ITreeCommonService<Organization, String> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Organization> findListByUserId(String userid);
}
