package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.UserOrganization;
import com.jeeopen.web.modules.sys.mapper.UserOrganizationMapper;
import com.jeeopen.web.modules.sys.service.IUserOrganizationService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("userOrganizationService")
public class UserOrganizationServiceImpl extends CommonServiceImpl<UserOrganizationMapper, UserOrganization>
		implements IUserOrganizationService {

}
