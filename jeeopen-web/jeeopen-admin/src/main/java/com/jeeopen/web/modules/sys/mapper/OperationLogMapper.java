package com.jeeopen.web.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.sys.entity.OperationLog;

import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.sys.mapper
* @title: 操作日志数据库控制层接口
* @description: 操作日志数据库控制层接口
 * @author: wangpf
* @date: 2018-09-30 15:53:25
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {

}