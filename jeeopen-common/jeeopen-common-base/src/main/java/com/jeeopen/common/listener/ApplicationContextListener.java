package com.jeeopen.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.jeeopen.common.listener.data.ApplicationInitable;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 * @title:  WebStartInitListener.java
 * @package com.jeeopen.modules.common.listener
 * @description:   spring容器初始化完成事件
 * @author: wangpf
 * @date:   2017年5月7日 下午2:35:48
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger _log = LoggerFactory.getLogger(ApplicationContextListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // root application context
        if(null == contextRefreshedEvent.getApplicationContext().getParent()) {
            _log.debug(">>>>> spring初始化开始 <<<<<");
            // 系统入口初始化
            Map<String, ApplicationInitable> baseInterfaceBeans = contextRefreshedEvent.getApplicationContext().getBeansOfType(ApplicationInitable.class);
            for(ApplicationInitable applicationInitable : baseInterfaceBeans.values()) {
                _log.debug(">>>>> {}.init()", applicationInitable.getClass().getName());
                try {
                    applicationInitable.init();
                } catch (Exception e) {
                    _log.error("初始化ApplicationInitable的init方法异常", e);
                    e.printStackTrace();
                }
            }

        }
    }

}
