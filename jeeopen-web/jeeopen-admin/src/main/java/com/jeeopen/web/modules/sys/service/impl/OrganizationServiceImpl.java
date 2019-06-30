package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.Organization;
import com.jeeopen.web.modules.sys.mapper.OrganizationMapper;
import com.jeeopen.web.modules.sys.service.IOrganizationService;
import com.jeeopen.common.mybatis.mvc.service.impl.TreeCommonServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<OrganizationMapper, Organization, String>
		implements IOrganizationService {

	@Override
	public List<Organization> findListByUserId(String userid) {
		return baseMapper.findListByUserId(userid);
	}

}
