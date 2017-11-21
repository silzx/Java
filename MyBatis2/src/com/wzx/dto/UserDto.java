package com.wzx.dto;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserDto implements HttpSessionBindingListener{
		private int id;
		private String name;
		private String pwd;
		private int age;
		private String nickname;
		private int role_no;
		private String yes;
		private String pic;
		private Role role;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		
		public int getRole_no() {
			return role_no;
		}
		public void setRole_no(int role_no) {
			this.role_no = role_no;
		}
		
		public String getYes() {
			return yes;
		}
		public void setYes(String yes) {
			this.yes = yes;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		@Override
		public void valueBound(HttpSessionBindingEvent arg0) {
			Integer index=(Integer) arg0.getSession().getServletContext().getAttribute("index");
			if(index!=null){
				index++;
			}else{
				index=1;
			}
			arg0.getSession().getServletContext().setAttribute("index", index);
		}
		@Override
		public void valueUnbound(HttpSessionBindingEvent arg0) {
			Integer index=(Integer) arg0.getSession().getServletContext().getAttribute("index");
			index--;
			arg0.getSession().getServletContext().setAttribute("index", index);
		}
}
