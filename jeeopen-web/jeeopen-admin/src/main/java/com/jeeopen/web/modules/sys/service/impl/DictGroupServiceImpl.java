package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.DictGroup;
import com.jeeopen.web.modules.sys.mapper.DictGroupMapper;
import com.jeeopen.web.modules.sys.service.IDictGroupService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper,DictGroup> implements IDictGroupService {
}
