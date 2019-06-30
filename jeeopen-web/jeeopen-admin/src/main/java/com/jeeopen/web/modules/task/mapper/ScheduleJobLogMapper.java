package com.jeeopen.web.modules.task.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.task.entity.ScheduleJobLog;

import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.task.mapper
* @title: 任务日志数据库控制层接口
* @description: 任务日志数据库控制层接口
 * @author: wangpf
* @date: 2018-09-17 14:25:18
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Mapper
public interface ScheduleJobLogMapper extends BaseMapper<ScheduleJobLog> {

}