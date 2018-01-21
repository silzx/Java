package com.zl.pojo;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author：汪泽轩
 * @Description: 客户业务 详细信息   
 * @Date:2018年1月4日下午3:26:10   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerInfo{
	private String uuid;//业务ID
	
	private String name;//申卡人姓名
	
	private String sex;//申卡人性别
	
	private Integer age;//申卡人年龄
	
	private String mobile;//申卡人手机
	
	private String idCard;//身份证
	
	private String applyArea;//申卡区域
	
	private Integer cardType;//申卡类型
	
	private int applyStatus;//申卡状态
	
	private String addMan;//提交人
	
	private String applyMethod;//申卡方式
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applyDate;//申卡时间x  c a
	
	private String firstAudit;//一审审核人
	
	private String secondAudit;//二审审核人
	
	@DateTimeFormat(pattern = "yyyy年MM月dd日")
	private Date firstAuditDate;//一审时间
	
	@DateTimeFormat(pattern = "yyyy年MM月dd日")
	private Date secondAuditDate;//二审时间
	
	private String edu;//教育程度
	
	private String zc;//职称
	
	private String zw;//职务
	
	private String jobType;//工作种类
	
	private String jobAddress;//工作地址
	
	private String companyName;//单位名称
	
	private String companyPhone;//单位联系电话
	
	private String homeAddress;//家庭地址
	
	private String marryed;//婚姻情况
	
	private String linkMan;//联系人
	
	private String linkMobile;//联系人手机
	
	private String linkNexus;//联系人与申办人关系
	
	private String salary;//年薪/收入证明
	
    private Double avabalance;
	
	private String asset;//资产复印件
	
	private String house;//住宅情况
	
	private String remark;//备注
	
	private String refereename;//推荐人
	
	private String ridcard;//推荐人身份证
	

	private String idCardCopy;//身份证复印件
	

	private String receipts;//收入凭证
	
	private Cardtype cardtypeObject;//卡种类型对象属性
	
	private Applystatus applyStatusType;//申卡状态属性
	
}
