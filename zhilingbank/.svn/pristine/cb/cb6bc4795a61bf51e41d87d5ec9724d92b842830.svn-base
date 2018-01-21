package com.zl.service.inter;


import java.util.List;

import com.zl.beans.CardCost;
import com.zl.pojo.MessageInfo;
import com.zl.pojo.User;

public interface IUserService {
	
	/**   
	 * @Title: querySaltByCardNum   
	 * @author：汪泽轩
	 * @Description: 根据卡号查询出盐值，登录需要二次加密               
	 */
	String querySaltByCardNum(String cardNum);
	
	/**   
	 * @Title: tradeByCardCost   
	 * @author：汪泽轩
	 * @Description: 支付验证：卡号，密码，以及三位CVV2码              
	 */
	User tradeByCardCost(CardCost cc);
	
	/**   
	 * @Title: cost   
	 * @author：汪泽轩
	 * @Description: 无溢出金时：消费-额度增减关系               
	 */
	boolean cost(CardCost cc);
	
	/**   
	 * @Title: costOverline   
	 * @author：汪泽轩
	 * @Description: 有溢出金时并且溢出金>价格             
	 */
	boolean costOverline(CardCost cc);
	
	/**   
	 * @Title: costOffOverline   
	 * @author：汪泽轩
	 * @Description: 有溢出金并且溢出金<价格               
	 */
	boolean costOffOverline(CardCost cc);
	
	/**   
	 * @Title: record   
	 * @author：汪泽轩
	 * @Description: 根据卡号查询未出账单的消费记录                
	 */
	List<MessageInfo> record(String cardNum);
	
}
