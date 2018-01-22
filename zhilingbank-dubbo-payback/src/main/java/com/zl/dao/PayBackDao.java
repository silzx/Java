package com.zl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zl.pojo.PayBackCard;

/**
 * @author admin
 *		还款查询
 */
@Mapper
public interface PayBackDao {

	/**
	 * @title:updatePayBackCard
	 * @author:黄超
	 * @Description:更改符合条件的银行卡金额	
	 */
	@Update("update bankinfo set balance=balance-#{money} where bankname=#{bankName} and cardNum=#{cardNum} and password=#{password} and balance>=#{money}")
	int updatePayBackCard(PayBackCard pbc);
}
