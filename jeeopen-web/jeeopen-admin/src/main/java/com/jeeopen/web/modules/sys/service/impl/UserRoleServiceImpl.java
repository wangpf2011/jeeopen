package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.UserRole;
import com.jeeopen.web.modules.sys.mapper.UserRoleMapper;
import com.jeeopen.web.modules.sys.service.IUserRoleService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl extends CommonServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService {

}
