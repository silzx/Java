package com.zl.beans;


import org.springframework.stereotype.Component;

@Component
public class RefundMoney {
	
		private String cardNum;			//还款卡号
		private Double overline;		//溢出金额
		private Double notRefundNow;	//未还款金额
		private Double avabalance;		//可用余额
		
		
		
		public String getCardNum() {
			return cardNum;
		}
		public void setCardNum(String cardNum) {
			this.cardNum = cardNum;
		}
		public Double getAvabalance() {
			return avabalance;
		}
		public void setAvabalance(Double avabalance) {
			this.avabalance = avabalance;
		}
		public Double getNotRefundNow() {
			return notRefundNow;
		}
		public void setNotRefundNow(Double notRefundNow) {
			this.notRefundNow = notRefundNow;
		}

		public Double getOverline() {
			return overline;
		}
		public void setOverline(Double overline) {
			this.overline = overline;
		}
		
		
		
}
