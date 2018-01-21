package com.zl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
























import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.HandlerExceptionResolver;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.zl.beans.BillsAndLine;
import com.zl.beans.PayBack;
import com.zl.beans.QueryInfo;
import com.zl.beans.RedisNeed;
import com.zl.beans.UnFreeze;
import com.zl.pojo.Bills;
import com.zl.pojo.CardMessage;
import com.zl.pojo.CustomerInfo;
import com.zl.pojo.PayBackCard;
import com.zl.pojo.TradeRecord;
import com.zl.service.ServiceTool;
import com.zl.service.inter.CardManageInter;
import com.zl.util.CustomerInfoUtil;
import com.zl.util.MD5Util;
import com.zl.util.RedisTool;
import com.zl.util.Uuid;

/**
 * @author：汪泽轩
 * @Description: 信用卡控制类  
 * @Date:2018年1月5日下午2:50:09   
 */

@Slf4j
@Controller
@Scope("prototype")
@RequestMapping("/card")
public class CardController implements HandlerExceptionResolver{
	
	@Autowired
	private CardManageInter cm;
	/**   
	 * @throws Exception 
	 * @throws IllegalStateException 
	 * @Title: cardApplication   
	 * @author：汪泽轩
	 * @Description: 用户页面申请               
	 */
	@RequestMapping("insert")
	public ModelAndView cardApplication(@Valid CustomerInfo ci,BindingResult bindingResult, String code, String p,String c,String d,HttpServletRequest request) throws IllegalStateException, Exception
	{	
		ModelAndView mv = new ModelAndView(); 
		System.out.println("进来了");
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			 if (!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
		          stream = new BufferedOutputStream(new FileOutputStream(
		              new File(file.getOriginalFilename())));
		          String fileName = file.getOriginalFilename();
		          String filePath = "/src/main/webapp/upload/";
		          File dd=new File("");
		          String str=dd.getCanonicalPath();
		          File dest = new File(str+filePath + fileName);
		          file.transferTo(dest);
		          stream.write(bytes);
		          stream.close();
				 
			 }
			 if(i==0) {
	        	  ci.setIdCardCopy(file.getOriginalFilename());
	          }
	          if(i==1){
	        	  ci.setReceipts(file.getOriginalFilename());
	        	  }
		}
		ci.setAge(CustomerInfoUtil.getCustomerAge(ci.getIdCard()));
		ci.setSex(CustomerInfoUtil.getCustomerGender(ci.getIdCard()));
		ci.setApplyArea(p+c+d);
		ci.setApplyDate(new Date());
		ci.setUuid(Uuid.getUuid());
		ci.setApplyMethod("网上申请");
		boolean flag = cm.cardApplication(ci);
		if(flag){
			mv.setViewName("redirect:/header.jsp");
		}
		return mv;
	}
	
	/**   
	 * @Title: codeCheck   
	 * @author：汪泽轩
	 * @Description: 手机验证码对比               
	 */
	@ResponseBody
	@RequestMapping("codecheck")
	public Map<String,Object> codeCheck(String code,String source){
		Map<String, Object> map = new HashMap<>();
		source = MD5Util.md5(source);
		boolean flag = MD5Util.md5(code).equals(source);
		if(flag){
			map.put("codecheck", true);
		}else{
			map.put("codecheck", false);
		}
		return map;
	}
	/**   
	 * @Title: cardFreeze   
	 * @author：汪泽轩
	 * @Description: 冻结方法               
	 */
	@RequestMapping("freeze")
	public String cardFreeze(String idCard){
		boolean flag = cm.cardFreeze(idCard);
		if(flag){
			return "success";
		}else{
			return "false";
		}
	}
	
	/**   
	 * @Title: cardUnfreeze   
	 * @author：汪泽轩
	 * @Description: 解冻方法               
	 */
	@RequestMapping("unfreeze")
	@ResponseBody
	public Map<String, Object> cardUnfreeze(UnFreeze uf,String source){
		Map<String, Object> map = new HashMap<>();
		String randomCode = null;//暂代手机验证码生成
		String code = MD5Util.md5(randomCode);//将验证码加密
		boolean flag = cm.cardUnfreeze(uf);
		if(flag){
			if(MD5Util.md5(source).equals(code)){//将页面传入的验证码加密,进行对比
				map.put("unfreeze", true);
			}else{
				map.put("unfreeze", false);
			}
		}return map;
	}
	/**
	 * @author 吕攀
	 * @Time 下午7:47:382018年1月9日
	 
	 */
	@RequestMapping("regIdcard")
	@ResponseBody
	public Map<String,Object> regIdcard(String idcard){
		Map<String, Object> map = new HashMap<>();
		int fg=cm.regUserByIdcard(idcard);
		if(fg>0){
			map.put("meg", true);
		}else{
			map.put("meg", false);
		}
		return map;
	}
	/**
	 * @author 吕攀
	 * @Time 下午7:47:382018年1月9日
	 */
	/*@RequestMapping("addRefereeInfo.do")
	public String addRefereeInfo(Referee rf){
		String id=Uuid.getUuid();
		rf.setId(id);
		cm.addRefereeInfo(rf);
		return "index";
	}*/
	
	
	
	/**
	 * @param 信用卡号
	 * @return 手机号
	 * @description 根据客户输入的信用卡号查到用户绑定的手机号
	 */
	@RequestMapping(value="getPhoneNum")
	@ResponseBody
	public Map<String, Object> getPhoneNum(CardMessage cm1){
		Map<String, Object> map = new HashMap<>();
		
		String phoneNum = cm.getPhoneNum(cm1);
		
		if(phoneNum != null){
			map.put("phoneNumMessage", true);
			map.put("phoneNum", phoneNum);
		}else{
			map.put("phoneNumMessage", false);
		}
		
		return map;
	}
	
	/**
	 * @param 支付密码
	 * @return true or false
	 * @description 判断输入的支付密码是否符合规则,支付密码必须为六位数纯数字
	 */
	@RequestMapping("judgePW")
	@ResponseBody
	public Map<String, Object> judgePW(String pw){
		Map<String, Object> map = new HashMap<>();
		
		if(pw.length() == 6){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(pw);
			if( isNum.matches() ){
				map.put("pwMessage", true);
			}else{
				map.put("pwMessage", false);
			}
		}else{
			map.put("pwMessage", false);
		}
		
		return map;
	}
	

	/**
	 * @title:cardRefund
	 * @author:黄超
	 * @Description:还款action调用service方法	
	 */
	@RequestMapping("cardRefund")
	@ResponseBody
	public Map<String,Object> cardRefund(String cardNum,Double refundMoney){
		Map<String,Object> json=new HashMap<String, Object>();
		int flag=cm.cardRefund(cardNum, refundMoney);	//调用还款方法
		if(flag>0){
			json.put("mess", true);
		}else{
			json.put("mess", false);
		}
		return json;
	}
	

	/**
	 * @param 信用卡激活资料
	 * @return true or false
	 * @description 激活信用卡，并添加账单记录
	 * @author 谢文奇
	 */
	@RequestMapping("activationCard")
	@ResponseBody
	public Map<String, Object> activationCard(CardMessage cm1,String password){
		Map<String, Object> map = new HashMap<>();
		//创建一个账单对象，激活一张信用卡的同时，生成一条账单记录
		Bills b = new Bills();
		//设置客户专属随机盐值
		cm1.setSalt(MD5Util.randomSalt());
		
		//获取当前时间并格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String d1 = sdf.format(new Date());
		//将格式化后的时间字符串再转换为时间类型，d2用来接收
		Date d2 = null;
		try {
			d2 = sdf.parse(d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//时间操作类对象实例cl
		Calendar cl=Calendar.getInstance();
		cl.setTime(d2);
		//cl.add(Calendar.MONTH, 1);//账单日 = 当前日期 + 一个月
		cm1.setBillDate(cl.getTime());
		b.setBillDate(cl.getTime());
		cl.add(Calendar.DAY_OF_MONTH, 20);//还款日 = 账单日 + 20天
		cm1.setRepayDate(cl.getTime()); 
		b.setPayBack(cl.getTime());
		//密码加盐加密
		cm1.setPassword(MD5Util.formToDataBases(password,cm1.getSalt()));
		
		/*
		 * 执行信用卡激活操作
		 * 如果信用卡激活成功了，再执行生成账单记录操作
		 */
		int count = cm.activationCard(cm1);
		if(count >= 1){
			/*
			 * 下一次出账时间 = 上一次出账时间 + 1个月
			 * 先减去还款日增加的20天，得到上一次出账时间
			 * 再加一个月
			 */
			cl.add(Calendar.DAY_OF_MONTH, -20);
			cl.add(Calendar.MONTH, 1);
			b.setNextBillDate(cl.getTime());
			
			//调用获取身份证号方法
			String idnum = cm.getIdCardcardNum(cm1);
			//将身份证号加入账单对象
			b.setIdCard(idnum);
			
			//将数据插入账单数据库
			int bCount = cm.insertBillInfo(b);
			if(bCount > 0){
				map.put("activationMessage", true);
			}else{
				map.put("activationMessage", false);
			}
		}else{
			map.put("activationMessage", false);
		}
		return map;
	} 
	
	/**
	 * @param 身份证号
	 * @return 手机号、信用卡申请状态
	 * @description 根据客户输入的身份证号查到用户绑定的手机号
	 */
	@RequestMapping(value="getPhoneNumByIdCard")
	@ResponseBody
	public Map<String, Object> getPhoneNumByIdCard(CustomerInfo ci){
		Map<String, Object> map = new HashMap<>();
		
		System.out.println("123");
		CustomerInfo ci1 = cm.getPhoneNumByIdCard(ci);
		
		if(ci1 != null){
			//0.1.2为正在审核
			if(ci1.getApplyStatus()==0 || ci1.getApplyStatus()==1 || ci1.getApplyStatus()==2){
				map.put("status", 0);
			}else if(ci1.getApplyStatus()==3){
				map.put("status", 1);
			}else{
				map.put("status", 2);
			}
			map.put("phoneNumMessage", true);
			map.put("phoneNum", ci1.getMobile());
		}else{
			map.put("phoneNumMessage", false);
		}
		
		return map;
	}

	/**
	 * @title:queryCardNumExist
	 * @author:黄超
	 * @Description:根据账户和用户名查询该账户是否存在	
	 */
	@RequestMapping("querycardnum")
	@ResponseBody
	public Map<String, Object> queryCardNumExist(QueryInfo qi){
		Map<String,Object> json=new HashMap<String,Object>();
		int flag=cm.queryCardNumIsExist(qi);
		if(flag>0){
			json.put("mess", true);
		}else{
			json.put("mess", false);
		}
		return json;
	}
	
	
	/**
	 * @param 卡号
	 * @return 手机号
	 * @description 根据卡号查询身份证号，再根据身份证号查询手机号
	 * @author 谢文奇
	 */
	@RequestMapping("getPhoneNumBycardNum")
	@ResponseBody
	public Map<String, Object> getPhoneNumBycardNum(CardMessage cm1, CustomerInfo ci){
		Map<String,Object> json=new HashMap<String,Object>();
		
		if(ci.getIdCard().equals(cm.getIdCardcardNum(cm1))){
			CustomerInfo ci1 = cm.getPhoneNumByIdCard(ci);
			if(ci1 != null){
				json.put("phoneNumMessage", true);
				json.put("phoneNum", ci1.getMobile());
			}else{
				json.put("phoneNumMessage", false);
			}
		}else{
			json.put("phoneNumMessage", false);
		}
		
		return json;
	}
	
	/**
	 * @param 卡号
	 * @return 更改卡状态是否成功
	 * @description 根据卡号修改卡的状态,包括挂失、解除挂失、注销
	 * @author 谢文奇
	 */
	@RequestMapping("cardLoss")
	@ResponseBody
	public Map<String, Object> cardLoss(CardMessage cm1, String cardstatus){
		Map<String,Object> json=new HashMap<String,Object>();
		
		int count = cm.cardLoss(cm1, cardstatus);
		if(count > 0){
			json.put("mess", true);
		}else{
			json.put("mess", false);
		}
		
		 return json;
	}
	
	/**
	 * @title:sendBill
	 * @author:黄超
	 * @Description:自动出账单，黄超	
	 */

	@Scheduled(cron="1 0 0 * * ?")
	public void sendBill(){
		BillsAndLine bal=new BillsAndLine();
		cm.updateBillsByAlready(bal); 
		System.out.println("出账单方法调用");
	}
	
	@Autowired
	private ServiceTool serviceTool;
	@Autowired
	private PayBackCard payBackCard;
	
	/**
	 * @title:payBackCard
	 * @author:黄超
	 * @Description:调用dubbo进行扣款，如果扣款成功则进行还款操作	
	 */
	@RequestMapping("payback")
	@ResponseBody
	public Map<String,Object> payBackCard(PayBack payBack){
		Map<String,Object> json=new HashMap<String, Object>();
		payBackCard.setBankName(payBack.getBankName());	//扣款银行
		payBackCard.setCardNum(payBack.getCardNum()); 	//扣款卡号
		payBackCard.setPassword(payBack.getPassword()); //扣款密码
		payBackCard.setMoney(payBack.getMoney()); 		//扣款金额
		int flag=serviceTool.payBack(payBackCard);		//调用dubbo中的接口方法进行扣款
		if(flag>0){			
			System.out.println("扣款成功");		//扣款成功进行还款
			int flags=cm.cardRefund(payBack.getCreditCardNum(), payBack.getMoney());
			if(flags>0){
				System.out.println("还款成功");
				json.put("mess", true);
			}else{
				System.out.println("还款操作失败");
				json.put("mess", false);
			}
		}
		return json;
	}
	
	/**
	 * @title:insertIntoRedis
	 * @author:黄超
	 * @Description:将数据存入session	
	 */
	@Autowired
	private RedisTool rt;
	@RequestMapping("insertRedis")
	public void insertIntoRedis(RedisNeed rn){
		System.out.println(rn.getStartDate()+" "+rn.getEndDate());
		List<TradeRecord> tradeRecords=cm.insertIntoRedis(rn);
		rt.setRedisObject(rn.getKey(), tradeRecords); 	//将数据存入redis
		System.out.println("方法运行完成");
	}

	/**   
	 * @Title: searchByidCard   
	 * @author：汪泽轩
	 * @Description: 根据身份证查询有无60天内重复申卡用户             
	 */
	@ResponseBody
	@PostMapping("search")
	public Map<String, Object> searchByidCard(String idCard){
		Map<String,Object> json=new HashMap<String, Object>();
		List<String> mobs = cm.searchMobile(idCard);
		if(mobs.size()>0){
			json.put("mes", true);
			return json;
		}else{
			json.put("mes", false);
			return json;
		}
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		
		return new ModelAndView("redirect:../admin/error.jsp");
	}
	
	
}





















