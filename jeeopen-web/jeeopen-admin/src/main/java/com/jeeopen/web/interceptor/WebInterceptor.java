package com.jeeopen.web.interceptor;

import com.jeeopen.web.modules.sys.entity.Menu;
import com.jeeopen.web.modules.sys.entity.User;
import com.jeeopen.web.security.shiro.realm.UserRealm;
import com.jeeopen.web.utils.MenuTreeHelper;
import com.jeeopen.web.utils.ThemeUtils;
import com.jeeopen.web.utils.UserUtils;
import com.jeeopen.common.utils.CookieUtils;
import com.jeeopen.common.utils.MessageUtils;
import com.jeeopen.common.utils.SpringContextHolder;
import com.jeeopen.common.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 公共拦截器
 * Created by wangpf on 2017/08/17.
 */

public class WebInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 静态资源目录
        Environment env = SpringContextHolder.getBean(Environment.class);
        String staticPath = env.getProperty("jeeopen.staticPath");
        String adminPath = env.getProperty("jeeopen.admin.url.prefix");
        //加入公用参数的
        String ctx = request.getServletContext().getContextPath();
        request.setAttribute("ctx",ctx);
        request.setAttribute("adminPath",ctx + adminPath);
        request.setAttribute("theme", ThemeUtils.getTheme());
        request.setAttribute("staticPath",staticPath);
        request.setAttribute("platformName", MessageUtils.getMessage("platform.name"));
        request.setAttribute("platformCopyright", MessageUtils.getMessage("platform.copyright"));
        request.setAttribute("platformVersion", MessageUtils.getMessage("platform.version"));
        UserRealm.Principal principal = UserUtils.getPrincipal(); // 如果已经登录，则跳转到管理首页
        if (principal!=null){
            try {
                Menu currentMenu = UserUtils.getCurrentMenu();
                if (currentMenu == null){
                    currentMenu = new Menu();
                }
                String pmenuids = currentMenu.getParentIds();
                request.setAttribute("currentMenu",currentMenu);
                if (!StringUtils.isEmpty(pmenuids)) {
                    request.setAttribute("pmenuids",pmenuids);
                }else{
                    request.setAttribute("pmenuids","");
                }
                List<MenuTreeHelper.MenuNode> menuNodes = MenuTreeHelper.create().sort(UserUtils.getMenuList());
                request.setAttribute("menus", menuNodes);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        request.setAttribute("loginUser",UserUtils.getUser());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
