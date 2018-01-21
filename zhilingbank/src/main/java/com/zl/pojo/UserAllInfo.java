package com.zl.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.stereotype.Component;

@Component
@WebListener
public class UserAllInfo implements Serializable,HttpSessionAttributeListener{

	private User user;
	private Bills bills;
	private CardMessage cardMessage;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bills getBills() {
		return bills;
	}
	public void setBills(Bills bills) {
		this.bills = bills;
	}
	public CardMessage getCardMessage() {
		return cardMessage;
	}
	public void setCardMessage(CardMessage cardMessage) {
		this.cardMessage = cardMessage;
	}
	
	private Map<String,HttpSession> sessionMap = new HashMap<String,HttpSession>();
	/* (non-Javadoc)
	 * 监听session防止重复登录
	 * 
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//获取session
		String sessionName=arg0.getName();
		if("uai".equals(sessionName)){		//如果session中存入的是uai代表是用户登录
			UserAllInfo uai=(UserAllInfo) arg0.getValue();		//获取到session存入的value
			//判断是否有相同session存在map中
			HttpSession oldSession=sessionMap.get(uai.getUser().getUsername());
			if(oldSession!=null){		//如果已经存在登录的用户session 则注销该session
				oldSession.removeAttribute("uai");
				oldSession.invalidate();
			}
			//将新登录的session放入map中
			sessionMap.put(uai.getUser().getUsername(), arg0.getSession());
		}
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}
	
	
}
