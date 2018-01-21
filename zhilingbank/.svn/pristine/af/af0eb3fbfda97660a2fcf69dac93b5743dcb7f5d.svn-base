package com.zl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.CardAuditSystemDao;
import com.zl.pojo.CustomerInfo;
import com.zl.pojo.Emp;
import com.zl.pojo.Info;
import com.zl.pojo.User;
import com.zl.service.inter.CardAuditSystem;
import com.zl.util.MD5Util;
@Service
public class CardAuditSystemImpl implements CardAuditSystem{
	@Autowired
	private CardAuditSystemDao cad;
	@Override
	public boolean queryuser(String account) {
		List<Emp> emp=cad.queryuser();
		for (Emp e : emp) {
			if(e.getAccount().equals(account)) {
				return true;
			}
		}
		return false;
	
	}
	
	@Override
	public Emp empLogin(String account,String pwd) {
		String salt=cad.QuerySalt(account);
		pwd=MD5Util.inputToDataBases(pwd, salt);
		return cad.empLogin(account, pwd);
	}
	

	@Override
	public void empUpdateInfo() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int salesmanAddInfo(CustomerInfo in) {
		// TODO Auto-generated method stub
		return cad.salesmanAddInfo(in);
	}

	@Override
	public List<CustomerInfo> salesmanQueryInfo(int pageno,int count) {
		// TODO Auto-generated method stub
		if(pageno<=1) {
			pageno=1;
		}
		return cad.salesmanQueryInfo((pageno-1)*count, count);
	}
	@Override
	public int getcountinfo() {
		// TODO Auto-generated method stub
		return cad.getcountinfo();
		
	}
	@Override
	public CustomerInfo salesmanShowInfo(String uuid) {
		// TODO Auto-generated method stub
		return cad.salesmanShowInfo(uuid);
	}


	@Override
	public int salesmanSubmitCustomer(String uuid,String idcardcopy,String receipts) {
		// TODO Auto-generated method stub
		return cad.salesmanSubmitCustomer(uuid, idcardcopy, receipts);
	}

	@Override
	public int adminAddEmp(Emp e) {
		// TODO Auto-generated method stub
		return cad.adminAddEmp(e);
	}

	@Override
	public int adminDeleteEmp(String empid) {
		// TODO Auto-generated method stub
		return cad.adminDeleteEmp(empid);
	}

	@Override
	public int adminUpdateEmp(Emp e) {
		
		return cad.adminUpdateEmp(e);
	}

	@Override
	public Emp adminShowInfo(String empid) {
		// TODO Auto-generated method stub
		return cad.adminShowInfo(empid);
	}

	

	@Override
	public void adminQueryDiscardCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Emp> adminQueryEmp(String account, int pageno, int count) {
		// TODO Auto-generated method stub
		if(pageno<=1) {
			pageno=1;
		}
		account="%"+account+"%";
		pageno=(pageno-1)*count;
		return cad.adminQueryEmp(account,pageno, count);
		
	}

	@Override
	public int getcount(String account,int count) {
		account="%"+account+"%";
		int totle=cad.getcount(account);
		if(totle%count==0) {
			return totle/count;
		}else {
			return totle/count+1;
		}
		
		
	}

	@Override
	public int adminUpdatePwd(String empid, String pwd) {
		String salt=cad.QuerySaltByempid(empid);		
		pwd=MD5Util.inputToDataBases(pwd, salt);
		return cad.adminUpdatePwd(empid, pwd);
		
	}

	@Override
	public String QuerySalt(String account) {
		
		return cad.QuerySalt(account);
		
	}

	
}
