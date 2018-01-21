package com.zl.Interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.zl.pojo.UserAllInfo;

@Component
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * filter防止未登录进入后台
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;	
		HttpServletResponse resp=(HttpServletResponse) arg1;
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		String urlpath=req.getServletPath();
		UserAllInfo uai=(UserAllInfo) req.getSession().getAttribute("uai");
		if(uai==null&&"/admin/user.jsp".equals(urlpath)){
			System.out.println("访问受限");
			resp.sendRedirect(basePath+"header.jsp");
		}else{
			arg2.doFilter(arg0, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器创建");
	}

}
