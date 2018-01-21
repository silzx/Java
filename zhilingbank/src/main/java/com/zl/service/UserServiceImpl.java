package com.zl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.zl.beans.CardCost;
import com.zl.dao.UserDao;
import com.zl.pojo.MessageInfo;
import com.zl.pojo.User;
import com.zl.service.inter.IUserService;
@Service
@Primary
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserDao ud;
	
	@Override
	public String querySaltByCardNum(String cardNum) {
		return ud.querySaltByCardNum(cardNum);
	}

	@Override
	public User tradeByCardCost(CardCost cc) {
		return ud.tradeByCardCost(cc);
	}

	@Override
	public boolean cost(CardCost cc) {
		return ud.cost(cc)>0?true:false;
	}

	@Override
	public boolean costOverline(CardCost cc) {
		return ud.costOverline(cc)>0?true:false;
	}

	@Override
	public boolean costOffOverline(CardCost cc) {
		return ud.costOffOverline(cc)>0?true:false;
	}

	@Override
	public List<MessageInfo> record(String cardNum) {
		List<MessageInfo> mes = ud.record(cardNum);
		return mes;
	}
	
}
