package com.jeeopen.web.modules.oa.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.oa.entity.OaNotification;

import org.apache.ibatis.annotations.Mapper;


/**
 *  通知公告数据库控制层接口
 */
@Mapper
public interface OaNotificationMapper extends BaseMapper<OaNotification> {
    
}