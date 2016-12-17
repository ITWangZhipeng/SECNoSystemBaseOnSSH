package com.sec.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/15.
 * 所有Action动作的父类
 */

public class SuperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {
    private static final long serialVersionUID = 1L;
    protected  HttpServletRequest request;//请求对象
    protected  HttpServletResponse response;//响应对象
    protected HttpSession session;//会话对象
    protected ServletContext application;//全局对象

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
        this.session = this.request.getSession();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.application = servletContext;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
