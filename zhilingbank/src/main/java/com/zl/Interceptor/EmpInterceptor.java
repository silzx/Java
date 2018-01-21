package com.zl.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zl.pojo.Emp;

public class EmpInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		response.setCharacterEncoding("UTF-8");

		
		String url = request.getRequestURI();


		url = url.substring(url.indexOf("/") + 1);
		if (url.indexOf("/") != -1) {
			String urlq = "";
			String urlh = "";
			
			if(url.equals("after/login")||url.equals("after/cancellation")||url.equals("after/af")||url.equals("after/emp")){
				
				return true;
				
			}else{
				
				urlq = url.substring(0, url.indexOf("/"));
				urlh = url.substring(url.indexOf("/")+1);
			}
			
			if (urlq.equals("salesman") || urlq.equals("afterAudit")|| urlq.equals("after")) {
				
				Emp e = (Emp) request.getSession().getAttribute("loginemp");
				
				if (e == null) {
					request.getRequestDispatcher("/after/af").forward(request,response);
					
				} else {
					
					
					
					if (e.getPos().getPid()==1) {
					
					
					}else if(e.getPos().getPid()==2){
						
						if(urlh.equals("firstIndex")||urlh.equals("firstInfo")||urlh.equals("firstSubmit")||urlh.equals("fsetRejected")){
							
							
							return true;
						}else{
							
							request.setAttribute("perm", "2");
							request.getRequestDispatcher("/afterAudit/firstIndex").forward(request,response);
							
						}
						
					}else if(e.getPos().getPid()==3){
						if(urlh.equals("secondIndex")||urlh.equals("secondInfo")||urlh.equals("secondSubmit")||urlh.equals("ssetRejected")||urlh.equals("cardValidation")||urlh.equals("promises")){
							return true;
						}else{
							
							request.setAttribute("perm", "3");
							request.getRequestDispatcher("/afterAudit/secondIndex").forward(request,response);
							
						}
						
					}else if(e.getPos().getPid()==4){
						if(urlq.equals("salesman")){
							return true;
							
						}else{
							request.setAttribute("perm", "4");
							request.getRequestDispatcher("/salesman/showinfomation").forward(request,response);
						}
						
					}else if(e.getPos().getPid()==5){
						if(urlh.equals("rejectedIndex")||urlh.equals("rejectedInfo")){
							return true;
							
						}else{
							request.setAttribute("perm", "5");
							request.getRequestDispatcher("/afterAudit/rejectedIndex").forward(request,response);
						}
						
					}
				}
			}
		}
		
	
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setCharacterEncoding("UTF-8");
	
			
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		
	}

}
