package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.Menu;
import com.jeeopen.web.modules.sys.mapper.MenuMapper;
import com.jeeopen.web.modules.sys.service.IMenuService;
import com.jeeopen.common.mybatis.mvc.service.impl.TreeCommonServiceImpl;
import com.jeeopen.common.mybatis.mvc.wrapper.EntityWrapper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("menuService")
public class MenuServiceImpl extends TreeCommonServiceImpl<MenuMapper, Menu, String> implements IMenuService {

	@Override
	public List<Menu> findMenuByUserId(String userId) {
		return baseMapper.findMenuByUserId(userId);
	}

	@Override
	public List<Menu> findMenuByRoleId(String roleId) {
		return baseMapper.findMenuByRoleId(roleId);
	}

	@Override
	public List<String> findPermissionByUserId(String userId) {
		return baseMapper.findPermissionByUserId(userId);
	}

	@Override
	public List<String> findPermissionByRoleId(String roleId) {
		return baseMapper.findPermissionByRoleId(roleId);
	}

	@Override
	public void generateButton(String menuId,
							   String parentPermission,
							   String[] permissions,
							   String[] permissionTitles) {
		EntityWrapper<Menu> deleteEntityWrapper = new EntityWrapper();
		deleteEntityWrapper.eq("parent_id",menuId);
		deleteEntityWrapper.eq("type",3);
		delete(deleteEntityWrapper);
		for (int i = 0; i < permissions.length; i++) {
			Menu menu = new Menu();
			menu.setParentId(menuId);
			menu.setName(permissionTitles[i]);
			menu.setPermission(parentPermission + ":" + permissions[i]);
			menu.setSort(i);
			menu.setType("3");
			menu.setEnabled((short) 1);
			insert(menu);
		}
	}
}
