package com.jeeopen.common.quartz.constant;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.common.quartz.constant
 * @title:
 * @description: 任务调度排序
 * @author: wangpf
 * @date: 2018/9/17 15:48
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public interface ScheduleConstants
{

    public static final String TASK_JOB_KEY_PRE_ = "TASK_JOB_KEY_PRE_";

    public static final String TASK_TRIGGER_KEY_PRE_ = "TASK_TRIGGER_KEY_PRE_";

    public static final String TASK_JOB_BAEN_KEY = "TASK_JOB_BAEN_KEY";

    /** 默认 */
    public static final String MISFIRE_DEFAULT = "0";

    /** 立即触发执行 */
    public static final String MISFIRE_IGNORE_MISFIRES = "1";

    /** 触发一次执行 */
    public static final String MISFIRE_FIRE_AND_PROCEED = "2";

    /** 不触发立即执行 */
    public static final String MISFIRE_DO_NOTHING = "3";


    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";

}
