package com.zl.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zl.pojo.PayBackCard;

/**
 * @author admin
 *		调用dubbo接口进行扣款操作
 */
@Component
public class ServiceTool {
	
	@Reference(version="1.0.0")
	BankCardService bankCardService;		//连接dubbo服务 提供get/set方法

	public BankCardService getBankCardService() {
		return bankCardService;
	}

	public void setBankCardService(BankCardService bankCardService) {
		this.bankCardService = bankCardService;
	}
	
	public int payBack(PayBackCard payBackCard){		//连接调用接口方法进行扣费
		System.out.println(payBackCard.getCardNum());
		if(bankCardService==null){
			System.out.println("没有找到相关服务");
			return 0;
		}else{
			int flag=bankCardService.updatePayBackCard(payBackCard);
			if(flag>0){
				System.out.println("扣费成功");
				return 1;
			}else{
				System.out.println("扣费失败");
				return 0;
			}
		}
		
		
	}

}
