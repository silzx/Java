package com.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.zl.pojo.Applystatus;
import com.zl.pojo.Cardtype;
import com.zl.pojo.CustomerInfo;
/** * 
@author    姚彬彬 
@date      2018年1月8日 下午7:35:07   
@describe  
 */
@Mapper
public interface FirstApprovalerDao {

	
	
	@SelectProvider(type = QueryCustomerList.class, method = "QueryCustomerListSql")  
	@Results({
			@Result(property="cardtypeObject",column="cardtype",one=@One(select="queryCardType")),
			@Result(property="applyStatusType",column="applyStatus",one=@One(select="queryApplyStatusType"))
	})	
	List<CustomerInfo> QueryCustomerList(@Param("cupage")Integer cupage,@Param("ofpage")Integer ofpage,@Param("fuzzy")final String fuzzy,@Param("applystatus")Integer applystatus);
	//sql动态拼接
	class QueryCustomerList {
		private static final char[] SQL = null;

		public String QueryCustomerListSql(@Param("cupage")Integer cupage,@Param("ofpage")Integer ofpage,@Param("fuzzy")final String fuzzy,@Param("applystatus")Integer applystatus) {
			return new SQL() {
				{
					SELECT("*");
					FROM("customerinfo");
					WHERE("applystatus=#{applystatus}");
					if (fuzzy != null || fuzzy != "") {
						WHERE("name like concat('%',#{fuzzy},'%')");
					}
				}
			}.toString()+"order by applyDate limit #{cupage},#{ofpage}";
		}
		
	}
	//卡种类型查询
	@Select("select * from cardtype where card_id=#{card_id}")
	Cardtype queryCardType(@Param("card_id")Integer card_id);

//	申卡状态查询
	@Select("select * from applystatus where applyid=#{applyStatus}")
	Applystatus queryApplyStatusType(@Param("applyStatus")Integer applyStatus);
	
	//数据量计算
	@Select("select count(*) from customerinfo where applystatus=#{1} and  name like concat('%',#{0},'%')")
	Integer queryCount(String fuzzy,Integer type);
	
	//查询一审数据详情
	@Select("select * from customerinfo where uuid=#{0}")
	@Results({
		@Result(property="cardtypeObject",column="cardtype",one=@One(select="queryCardType")),
		@Result(property="applyStatusType",column="applyStatus",one=@One(select="queryApplyStatusType"))
     })	
	CustomerInfo QueryCustomer(String uuid);
	
	//一审通过修改类型进入二审
	@Update("update customerinfo set applystatus=applystatus+1 where uuid=#{uuid}")
	boolean UpdateCustomerType(String uuid);
	
	//审核未通过驳回
	@Update("update customerinfo set applystatus=4,remark=#{1} where uuid=#{0}")
	boolean UpdateCustomerRejected(String uuid,String rejectedText);
}
