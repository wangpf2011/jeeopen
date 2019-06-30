package com.jeeopen.web.modules.sys.mapper;

import java.util.List;

import com.jeeopen.web.modules.sys.entity.Organization;
import com.jeeopen.common.mybatis.mvc.mapper.BaseTreeMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper extends BaseTreeMapper<Organization> {
	
	/**
	 * 
	 * @title: findListByUserId
	 * @description: 通过用户查找组织机构
	 * @param userId
	 * @return
	 * @return: List<Organization>
	 */
	List<Organization> findListByUserId(String userId);
}