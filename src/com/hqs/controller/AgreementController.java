package com.hqs.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hqs.common.Page;
import com.hqs.model.Agreement;
import com.hqs.model.Agreementcate;
import com.hqs.service.AgreementService;
import com.hqs.service.AgreementcateService;


@Controller
public class AgreementController {
	@Autowired
	private AgreementService agreementService;
	@Autowired
	private AgreementcateService agreementcateService;
	
	@RequestMapping("/agreement/index")
	public ModelAndView index(HttpServletRequest request, Page<Agreement> page, Agreement agreement1){
		ModelAndView mav = new ModelAndView();
		agreement1 = agreement1 == null  ? new Agreement() : agreement1;
		page.getParams().put("name", agreement1.getName());
		page.getParams().put("projectname", agreement1.getProjectname());
		page = agreementService.queryPage(page);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("/agreement/add")
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView();
		List<Agreementcate> agreementlist = agreementcateService.findAll();
		mav.addObject("agreementlist", agreementlist);
		return mav;	
	}
	
	@RequestMapping("/agreement/doAdd")
	public ModelAndView doAdd(Agreement agreement){
		ModelAndView mav = new ModelAndView();
		try{
			agreement.setCreatetime(new Date());
			agreementService.add(agreement);
			mav.addObject("success", true);
			mav.setViewName("redirect:/agreement/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/agreement/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/agreement/changestatus")
	public ModelAndView changestatus(int id){
		ModelAndView mav = new ModelAndView();

		Agreement agreement = agreementService.findById(id);
		if(agreement.getState()==0){
			agreement.setState(1);
		}else{
			agreement.setState(0);
		}
		agreementService.update(agreement);
		mav.addObject("success", true);
		mav.setViewName("redirect:/agreement/index");
		
		return mav;
	}
	
	@RequestMapping("/agreement/update")
	public ModelAndView update(int id){
		ModelAndView mav = new ModelAndView();
		List<Agreementcate> agreementlist = agreementcateService.findAll();
		mav.addObject("agreementlist", agreementlist);
		Agreement agreement = new Agreement();
		agreement = agreementService.findById(id);
		mav.addObject("agreement", agreement);
		return mav;
	}
	@RequestMapping("/agreement/doUpdate")
	public ModelAndView doUpdate(Agreement agreement){
		ModelAndView mav = new ModelAndView();
		try{
			agreement.setCreatetime(new Date());
			agreementService.update(agreement);
			mav.addObject("success", true);
			mav.setViewName("redirect:/agreement/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/agreement/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/agreement/delete")
	public String delete(HttpServletRequest request, int id){
		agreementService.delete(id);
		return "redirect:/agreement/index";
	}

}
