package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.Role;
import com.jeeopen.web.modules.sys.mapper.RoleMapper;
import com.jeeopen.web.modules.sys.service.IRoleService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleService")
public class RoleServiceImpl extends CommonServiceImpl<RoleMapper, Role> implements IRoleService {

	@Override
	public List<Role> findListByUserId(String userid) {
		return baseMapper.findRoleByUserId(userid);
	}

}
