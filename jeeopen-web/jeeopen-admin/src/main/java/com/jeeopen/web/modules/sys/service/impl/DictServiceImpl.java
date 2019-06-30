package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.Dict;
import com.jeeopen.web.modules.sys.mapper.DictMapper;
import com.jeeopen.web.modules.sys.service.IDictService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictMapper, Dict> implements IDictService {

	@Override
	public List<Dict> selectDictList() {
		return baseMapper.selectDictList();
	}

}
