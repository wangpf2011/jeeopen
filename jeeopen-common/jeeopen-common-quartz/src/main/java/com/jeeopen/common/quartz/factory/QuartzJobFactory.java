package com.jeeopen.common.quartz.factory;

import com.jeeopen.common.quartz.callback.QuartzExecuteCallback;
import com.jeeopen.common.quartz.constant.ScheduleConstants;
import com.jeeopen.common.quartz.data.ScheduleJob;
import com.jeeopen.common.utils.SpringContextHolder;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * @title:  QuartzJobFactory.java   
 * @package com.jeeopen.core.quartz.factory   
 * @description:   计划任务执行处 无状态
 * @author: wangpf   
 * @date:   2017年5月10日 上午12:24:41   
 * @version V1.0 
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved. 
 *
 */
public class QuartzJobFactory extends QuartzJobBean {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get(ScheduleConstants.TASK_JOB_BAEN_KEY);
		QuartzExecuteCallback quartzExecuteCallback = SpringContextHolder.getBean(QuartzExecuteCallback.class);
		long startTime = System.currentTimeMillis();
		try
		{
			quartzExecuteCallback.onStart(scheduleJob);
			// 执行任务
			logger.info("任务开始执行 - 名称：{} 方法：{}", scheduleJob.getJobName(), scheduleJob.getMethodName());
			ScheduleJobinvoke.invokeMethod(scheduleJob);
			long times = System.currentTimeMillis() - startTime;
			String message = scheduleJob.getJobName() + " 总共耗时：" + times + "毫秒";
			quartzExecuteCallback.onSuccess(scheduleJob,message);
			logger.info("任务执行结束 - 名称：{} 耗时：{} 毫秒", scheduleJob.getJobName(), times);
		}
		catch (Exception e)
		{
			logger.info("任务执行失败 - 名称：{} 方法：{}", scheduleJob.getJobName(), scheduleJob.getMethodName());
			logger.error("任务执行异常  - ：", e);
			long times = System.currentTimeMillis() - startTime;
			String message = scheduleJob.getJobName() + " 总共耗时：" + times + "毫秒";
			quartzExecuteCallback.onFailure(scheduleJob,e,message);
		}
		finally
		{
			//jobLogService.addJobLog(jobLog);
			//日志保存
		}
	}
}