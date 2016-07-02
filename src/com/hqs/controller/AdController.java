package com.hqs.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hqs.common.Page;
import com.hqs.model.Ad;
import com.hqs.service.AdService;

@Controller
public class AdController {
	@Autowired
	private AdService adService;
	
	@RequestMapping("/ad/index")
	public ModelAndView index(HttpServletRequest request, Page<Ad> page, Ad ad){
		ModelAndView mav = new ModelAndView();
		ad = ad == null  ? new Ad() : ad;
		page.getParams().put("title", ad.getTitle());
		page = adService.queryPage(page);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("/ad/add")
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView();
		return mav;	
	}
	
	@RequestMapping("/ad/doAdd")
	public ModelAndView doAdd(Ad ad){
		ModelAndView mav = new ModelAndView();
		try{
			ad.setCreatetime(new Date());
			adService.add(ad);
			mav.addObject("success", true);
			mav.setViewName("redirect:/ad/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/ad/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/ad/update")
	public ModelAndView update(int id){
		ModelAndView mav = new ModelAndView();
		Ad ad = new Ad();
		ad = adService.findById(id);
		mav.addObject("ad", ad);
		return mav;
	}
	@RequestMapping("/ad/doUpdate")
	public ModelAndView doUpdate(Ad ad){
		ModelAndView mav = new ModelAndView();
		try{
			ad.setCreatetime(new Date());
			adService.update(ad);
			mav.addObject("success", true);
			mav.setViewName("redirect:/ad/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/ad/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/ad/delete")
	public String delete(HttpServletRequest request, int id){
		adService.delete(id);
		return "redirect:/ad/index";
	}


}
