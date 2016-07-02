package com.hqs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hqs.common.Page;
import com.hqs.model.Role;
import com.hqs.model.User;
import com.hqs.service.RoleService;
import com.hqs.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/user/index")
	public ModelAndView index(HttpServletRequest request, Page<User> page, User user){
		ModelAndView mav = new ModelAndView();
		user = user == null  ? new User() : user;
		page.getParams().put("username", user.getUsername());
		page = userService.queryPage(page);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("/user/add")
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView();
		List<Role> rolelist = roleService.findAll();
		mav.addObject("rolelist", rolelist);
		return mav;	
	}
	
	@RequestMapping("/user/doAdd")
	public ModelAndView doAdd(User user){
		ModelAndView mav = new ModelAndView();
		try{
			userService.register(user);
			mav.addObject("success", true);
			mav.setViewName("redirect:/user/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/user/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/user/update")
	public ModelAndView update(int id){
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user = userService.findById(id);
		mav.addObject("user", user);
		List<Role> rolelist = roleService.findAll();
		mav.addObject("rolelist", rolelist);
		return mav;
	}
	@RequestMapping("/user/doUpdate")
	public ModelAndView doUpdate(User user){
		ModelAndView mav = new ModelAndView();
		try{
			userService.update(user);
			mav.addObject("success", true);
			mav.setViewName("redirect:/user/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/user/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/user/delete")
	public String delete(HttpServletRequest request, int id){
		userService.delete(id);
		return "redirect:/user/index";
	}

	@RequestMapping("/user/loginView")
	public String login(HttpServletRequest request ){
		return "login";
	}
	
	@RequestMapping("/user/listView")
	public ModelAndView listUser(HttpServletRequest request ){
		ModelAndView mav = new ModelAndView();

		List<User> users = userService.findAllUser();
		
		if (null == users){
			mav.setViewName("error");
			mav.addObject("errorMsg", "�û���Ϣ���س��?");
		}else{
			mav.setViewName("listuser");
			mav.addObject("users", users);
		}

		return mav;
	}
	
	@RequestMapping("/user/registerView")
	public String registerView(){
		return "register";
	}
	
	/*@RequestMapping("/user/login")
	public ModelAndView login(User user){
		
		ModelAndView mav = new ModelAndView();
		User u = userService.loginCheck(user);

		if(null==u){
			mav.setViewName("login");
			mav.addObject("errorMsg","�û������������");
			
			return mav;
		}
		else{
			mav.setViewName("success");
			mav.addObject("user", u);
			return mav;
		}
	}*/
	
	/*@RequestMapping("/user/register")
	public ModelAndView register(User user){
	
		ModelAndView mav = new ModelAndView();
		if(userService.register(user)){
			mav.setViewName("register_succ");
		}
		else{
			mav.setViewName("register");
			mav.addObject("errorMsg","�û����ѱ�ռ�ã�����");
			
		}
		return mav;
	}*/
	
	@RequestMapping("/user/deleteView")
	public ModelAndView delete(int userid, String userName){
		System.out.println("delete()   "); 
		ModelAndView mav = new ModelAndView();
		
		if (userService.delete(userid)){
			mav.setViewName("operate_succ");
			mav.addObject("userName", userName);
			mav.addObject("msg", "ɾ���û��ɹ���");
			
		}else{
			mav.setViewName("error");
			mav.addObject("errorMsg","ɾ��ʧ�ܣ�");
			
		}
		
		return mav;
	}
	
	@RequestMapping("/user/changeView")
	public ModelAndView change(int userid, String userName){
		
		System.out.println("change() method!");
		ModelAndView mav = new ModelAndView("changeuser");
		mav.addObject("userid", userid);
		mav.addObject("userName", userName);
		
		return mav;
	}
	
	/*@RequestMapping("/user/changeUser")
	public ModelAndView changeUser(int userid, String name){
		
		System.out.println("name="+ name);
		System.out.println("userid="+ userid);
		
		ModelAndView mav = new ModelAndView();
		
		if (userService.changeUser(name, userid)){
			mav.setViewName("operate_succ");
			mav.addObject("userName", name);
			mav.addObject("msg", "�޸��û��ɹ�!");
			
		}else{
			mav.setViewName("error");
			mav.addObject("errormsg", "�޸�ʧ�ܣ�");
		}
		
		return mav;
	}*/
	
}
