package com.jeeopen.common.disruptor;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: LongEvent.java
 * @package cn.gov.gzst.common.disruptor.sms
 * @description: 内容传递
 * @author: wangpf
 * @date: 2017年6月7日 下午11:17:40
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class TaskEvent {
   private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}