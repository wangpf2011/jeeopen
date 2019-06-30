package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.RoleMenu;
import com.jeeopen.web.modules.sys.mapper.RoleMenuMapper;
import com.jeeopen.web.modules.sys.service.IRoleMenuService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService {

}
