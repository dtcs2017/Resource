package com.hqs.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hqs.common.Page;
import com.hqs.model.Agreement;
import com.hqs.model.Cost;
import com.hqs.service.AgreementService;
import com.hqs.service.CostService;

@Controller
public class CostController {
	@Autowired
	private CostService costService;
	@Autowired
	private AgreementService agreementService;
	
	@RequestMapping("/cost/index")
	public ModelAndView index(HttpServletRequest request, Page<Agreement> page, Agreement agreement){
		ModelAndView mav = new ModelAndView();
		agreement = agreement == null  ? new Agreement() : agreement;
		page.getParams().put("name", agreement.getName());
		page.getParams().put("projectname", agreement.getProjectname());
		page = agreementService.queryPage(page);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("/cost/add")
	public ModelAndView add(int agreementid){
		ModelAndView mav = new ModelAndView();
		mav.addObject("agreementid", agreementid);
		return mav;	
	}
	
	@RequestMapping("/cost/doAdd")
	public ModelAndView doAdd(Cost cost, int agreementid){
		ModelAndView mav = new ModelAndView();
		try{
			cost.setAgreementid(agreementid);
			cost.setCreatetime(new Date());
			costService.add(cost);
			mav.addObject("success", true);
			mav.setViewName("redirect:/cost/index");
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("redirect:/cost/add");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/cost/view")
	public ModelAndView view(HttpServletRequest request, Page<Cost> page, Cost cost, int agreementid){
		ModelAndView mav = new ModelAndView();
		cost = cost == null  ? new Cost() : cost;
		page.getParams().put("title", cost.getTitle());
		page.getParams().put("agreementid", agreementid);
		page = costService.queryPage(page);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("/cost/update")
	public ModelAndView update(int id){
		ModelAndView mav = new ModelAndView();
		Cost cost = new Cost();
		cost = costService.findById(id);
		mav.addObject("cost", cost);
		return mav;
	}
	@RequestMapping("/cost/doUpdate")
	public ModelAndView doUpdate(Cost cost){
		ModelAndView mav = new ModelAndView();
		Cost cost1 = costService.findById(cost.getId());
		try{
			cost.setCreatetime(new Date());
			costService.update(cost);
			mav.addObject("success", true);
			mav.setViewName("redirect:/cost/view?agreementid="+cost1.getAgreementid());
		} catch(Exception e){
			mav.addObject("success", false);
			mav.setViewName("/cost/update?id="+cost.getId());
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/cost/delete")
	public String delete(HttpServletRequest request, int id){
		costService.delete(id);
		Cost cost = costService.findById(id);
		return "redirect:/cost/view?agreementid="+cost.getAgreementid();
	}

}
