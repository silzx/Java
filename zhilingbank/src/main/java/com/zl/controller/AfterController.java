package com.zl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/** * 
@author    姚彬彬 
@date      2018年1月11日 下午8:24:29   
@describe  
 */
@RestController
public class AfterController {

	@RequestMapping("/after")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/after/login");
		return mv;
	}
}
