package com.jeeopen.web.modules.sms.controller;

import com.jeeopen.common.http.PageResponse;
import com.jeeopen.common.http.Response;
import com.jeeopen.common.mvc.annotation.ViewPrefix;
import com.jeeopen.common.mvc.controller.BaseBeanController;
import com.jeeopen.common.mybatis.mvc.wrapper.EntityWrapper;
import com.jeeopen.common.query.annotation.PageableDefaults;
import com.jeeopen.common.query.data.PropertyPreFilterable;
import com.jeeopen.common.query.data.Queryable;
import com.jeeopen.common.query.utils.QueryableConvertUtils;
import com.jeeopen.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.jeeopen.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.jeeopen.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.jeeopen.web.aspectj.annotation.Log;
import com.jeeopen.web.aspectj.enums.LogType;
import com.jeeopen.web.modules.sms.entity.SmsSendLog;
import com.jeeopen.web.modules.sms.service.ISmsSendLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.modules.sms.controller
 * @title: 发送日志控制器
 * @description: 发送日志控制器
 * @author: wangpf
 * @date: 2018-09-14 09:47:53
 * @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
 */

@RestController
@RequestMapping("${jeeopen.admin.url.prefix}/sms/sendlog")
@RequiresPathPermission("sms:sendlog")
@ViewPrefix("modules/sms/sendlog")
@Log(title = "短信发送日志")
public class SmsSendLogController extends BaseBeanController<SmsSendLog> {

    @Autowired
    private ISmsSendLogService smsSendLogService;



    @GetMapping
    @RequiresMethodPermissions("view")
    public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return displayModelAndView("list");
    }
    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<SmsSendLog> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<SmsSendLog> pagejson = new PageResponse<>(smsSendLogService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    @PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response delete(@PathVariable("id") String id) {
        smsSendLogService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping("batch/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        smsSendLogService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }

}