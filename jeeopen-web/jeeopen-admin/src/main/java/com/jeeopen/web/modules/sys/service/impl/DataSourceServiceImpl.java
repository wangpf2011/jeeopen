package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.DataSource;
import com.jeeopen.web.modules.sys.mapper.DataSourceMapper;
import com.jeeopen.web.modules.sys.service.IDataSourceService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 数据源
 * @Description: 数据源
 * @author wangpf
 * @date 2017-05-10 12:01:57
 * @version V1.0   
 *
 */
@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl  extends CommonServiceImpl<DataSourceMapper,DataSource> implements  IDataSourceService {

}
