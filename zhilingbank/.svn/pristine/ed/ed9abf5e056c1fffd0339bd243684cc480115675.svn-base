package com.zl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import com.zl.pojo.CustomerInfo;
import com.zl.pojo.Emp;
import com.zl.service.inter.FirstApprovaler;
import com.zl.service.inter.InterfaceService;
import com.zl.service.inter.SecondApprovaler;
import com.zl.tool.rsa;
import com.zl.util.InterfaceCall;

/**
 * *
 * 
 * @author 姚彬彬
 * @date 2018年1月8日 下午5:24:02
 * @describe 信用卡审核Controller
 */
@RestController
@RequestMapping("afterAudit")
public class AfterAuditController {

	@Autowired
	private FirstApprovaler faService;
	@Autowired
	private SecondApprovaler saService;
	@Autowired
	private InterfaceCall ifService;


	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @describe 测试rsa
	 */
	// 首页 http://localhost:8080/afterAudit/rsa
	@RequestMapping("rsa")
	public ModelAndView admin(HttpServletRequest request) throws IOException {

		ModelAndView mv = new ModelAndView("/after/rsa/index");
		return mv;
	}

	// ajax获取公钥
	@RequestMapping("rsaPuKey")
	public void rsaPuKey(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out;
		out = response.getWriter();
		rsa r = new rsa();
		JSONObject json = new JSONObject();
		json.put("pukey", r.PuYey());
		out.print(json);
		out.close();
	}

	// 传回来的数据进行解密
	@RequestMapping("idcard")
	public void idCard(HttpServletResponse response,
			HttpServletRequest request, HttpSession sseion) throws Exception {
		rsa r = new rsa();
		String card_name = request.getParameter("card_name");
		String card_id = request.getParameter("card_id");

		System.out.println("加密的名字：" + card_name);
		System.out.println("加密的ID：" + card_id);
		// 调用rsa类的解密方法
		card_name = r.getDecrypt(card_name, "");
		card_id = r.getDecrypt(card_id, "");
		System.out.println("解密后的名字：" + card_name);
		System.out.println("解密后的ID：" + card_id);
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 一审主页
	 */
	@RequestMapping("firstIndex")
	public ModelAndView firstList(HttpServletRequest request) {
		String cupage = request.getParameter("cupage");
		String fuzzy = request.getParameter("fuzzy");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/audit/first/index");

		List<CustomerInfo> customer_list = faService
				.firstApprovalerQueryCustomer(cupage, fuzzy, 1);
		List count_list = faService.queryCount(fuzzy, 1);
		mv.addObject("customer_list", customer_list);
		mv.addObject("count", count_list.get(0));
		mv.addObject("pages", count_list.get(1));
		mv.addObject("cupage", cupage == null ? "1" : cupage);
		mv.addObject("fuzzy", fuzzy == null ? "" : fuzzy);

		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 一审详情
	 */
	@RequestMapping("firstInfo")
	public ModelAndView firstInfo(HttpServletRequest request) {
		String uuid = request.getParameter("uuid");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/audit/first/info");
		CustomerInfo customer = faService.firstApprovalerShowInfo(uuid);
		mv.addObject("customer", customer);

		// Jedis je = new Jedis();
		// je.getSet("customer", customer);
		System.out.println(customer);
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 一审提交
	 */
	@RequestMapping("firstSubmit")
	public ModelAndView firstSubmit(CustomerInfo c) {
		ModelAndView mv = new ModelAndView();
		faService.firstApprovalerSubmitCustomer(c.getUuid());
		mv.setViewName("redirect:/afterAudit/firstIndex");

		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 驳回主页
	 */

	@RequestMapping("rejectedIndex")
	public ModelAndView rejectedList(HttpServletRequest request) {
		String cupage = request.getParameter("cupage");
		String fuzzy = request.getParameter("fuzzy");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/audit/rejected/index");
		List<CustomerInfo> customer_list = faService
				.firstApprovalerQueryCustomer(cupage, fuzzy, 4);
		List count_list = faService.queryCount(fuzzy, 4);

		mv.addObject("customer_list", customer_list);
		mv.addObject("count", count_list.get(0));
		mv.addObject("pages", count_list.get(1));
		mv.addObject("cupage", cupage == null ? "1" : cupage);
		mv.addObject("fuzzy", fuzzy == null ? "" : fuzzy);
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 驳回详情
	 */
	@RequestMapping("rejectedInfo")
	public ModelAndView rejectedInfo(HttpServletRequest request) {
		String uuid = request.getParameter("uuid");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/audit/rejected/info");
		CustomerInfo customer = faService.firstApprovalerShowInfo(uuid);
		mv.addObject("customer", customer);
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 一审驳回
	 */
	@RequestMapping("fsetRejected")
	public ModelAndView fsetRejected(HttpServletRequest request) {
		String rejectedText = request.getParameter("rejectedText");
		rejectedText = "一审驳回:" + rejectedText;
		String uuid = request.getParameter("uuid");
		ModelAndView mv = new ModelAndView();
		faService.firstApprovalerDiscardCustomer(uuid, rejectedText);
		mv.setViewName("redirect:/afterAudit/firstIndex");
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 二审驳回
	 */
	@RequestMapping("ssetRejected")
	public ModelAndView ssetRejected(HttpServletRequest request) {
		String rejectedText = request.getParameter("rejectedText");
		rejectedText = "二审驳回:" + rejectedText;
		String uuid = request.getParameter("uuid");
		ModelAndView mv = new ModelAndView();
		faService.firstApprovalerDiscardCustomer(uuid, rejectedText);
		mv.setViewName("redirect:/afterAudit/secondIndex");
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 二审主页
	 */
	@RequestMapping("secondIndex")
	public ModelAndView secondList(HttpServletRequest request) {
		String cupage = request.getParameter("cupage");
		String fuzzy = request.getParameter("fuzzy");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/audit/second/index");
		List<CustomerInfo> second_list = saService
				.secondApprovalerQueryCustomer(cupage, fuzzy);
		mv.addObject("second_list", second_list);
		List count_list = faService.queryCount(fuzzy, 2);
		mv.addObject("count", count_list.get(0));
		mv.addObject("pages", count_list.get(1));
		mv.addObject("cupage", cupage == null ? "1" : cupage);
		mv.addObject("fuzzy", fuzzy == null ? "" : fuzzy);
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 二审详情
	 */
	@RequestMapping("secondInfo")
	public ModelAndView secondInfo(HttpServletRequest request) {
		String uuid = request.getParameter("uuid");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/audit/second/info");
		CustomerInfo customer = saService.secondApprovalerShowInfo(uuid);

		mv.addObject("customer", customer);
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 二审提交
	 */
	@RequestMapping("secondSubmit")
	public ModelAndView secondSubmit(CustomerInfo c) {

		ModelAndView mv = new ModelAndView();
		CustomerInfo customer = saService.secondApprovalerShowInfo(c.getUuid());
		customer.setAvabalance(Double.valueOf(c.getAvabalance()));
		saService.secondApprovalerSubmitCustomer(customer);
		mv.setViewName("redirect:/afterAudit/secondIndex");

		return mv;

	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @throws Exception
	 * 
	 * @date 2018年1月10日 下午8:17:49
	 * @describe 二审身份证实名验证
	 */
	@RequestMapping("cardValidation")
	public void seconCardValidation(HttpServletRequest request,
			HttpServletResponse response) throws IOException, Exception {
		String card_id = request.getParameter("idCard");
		String card_name = request.getParameter("name");
		PrintWriter out = null;
		out = response.getWriter();
		// JSONObject json = ifService.interfaceIdCard(card_name, card_id);
		JSONObject json = new JSONObject();
		json.put("charge", true);

		out.print(json);
		out.close();

	}

	// http://localhost:8085/afterAudit/promises
	@RequestMapping("promises")
	public void seconPromises(HttpServletRequest request,
			HttpServletResponse response) throws IOException, Exception {
		String card_id = request.getParameter("idCard");
		String card_name = request.getParameter("name");
		card_id = "43";
		card_name = "11";
		PrintWriter out = null;
		out = response.getWriter();
		// JSONObject json = ifService.interfaceCredit(card_name, card_id);
		JSONObject json = new JSONObject();
		json.put("charge", true);

		out.print(json);
		out.close();

	}

}
