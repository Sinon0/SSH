package com.wy.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wy.entity.User;
import com.wy.service.UserService;

public class UserAction {
	User user;
	UserService service;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public UserService getService() {
		return service;
	}

	@Resource(name="service")
	public void setService(UserService service) {
		this.service = service;
	}

	/**
	 * @author Sinon
	 * @return
	 * 注册
	 */
	public String add(){
		service.add(user);
		/**
		 * @author Sinon
		 * 当用户注册成功后，就将当前当前登录信息保存在application当中
		 */
		ActionContext.getContext().getSession().put("USER", user);
		return "main";
	}
	/**
	 * @author Sinon
	 * 判断用户是否存在Action调用
	 * @throws IOException 
	 */
	public String checkExists() throws IOException{
		boolean flag=service.checkExists(user);
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		if(flag){
			out.print("1");
		}else{
			out.print("0");
		}
		return null;
	}
	/**
	 * @author Sinon
	 * 登录方法
	 */
	public String login(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String result="login";
		if(service.checkExists(user)){
			session.setAttribute("USER", user); 
			result="main";
		}
		/**
		 * 1.首先接收到用户名和密码
		 * 2.判断用户名密码是否正确
		 */
		return result;
	}
	/**
	 * @author Sinon
	 * 用户注销操作
	 */
	public String logout(){
		HttpServletRequest request=(HttpServletRequest)ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		//让Session失效
		session.setAttribute("USER", null);
		return "main";
	}
}