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

import com.zl.dao.FirstApprovalerDao.QueryCustomerList;
import com.zl.pojo.Applystatus;
import com.zl.pojo.Cardtype;
import com.zl.pojo.CustomerInfo;

/**
 * *
 * 
 * @author 姚彬彬
 * @date 2018年1月9日 下午12:35:50
 * @describe
 */
@Mapper
public interface SecondApprovalerDao {

	// 获取二审数据列表
//	@Select("select * from customerinfo  where applystatus=2 and name like concat('%',#{2},'%') order by applyDate  limit #{0},#{1} ")
	@SelectProvider(type = QueryCustomerList.class, method = "QueryCustomerListSql")  
	@Results({
		@Result(property="cardtypeObject",column="cardtype",one=@One(select="queryCardType")),
		@Result(property="applyStatusType",column="applyStatus",one=@One(select="queryApplyStatusType"))
})	
	List<CustomerInfo> secondApprovalerQueryCustomer(@Param("cupage")Integer cupage,@Param("ofpage")Integer ofpage,@Param("fuzzy")final String fuzzy);

	class QueryCustomerList {
		private static final char[] SQL = null;

		public String QueryCustomerListSql(@Param("cupage")Integer cupage,@Param("ofpage")Integer ofpage,@Param("fuzzy")final String fuzzy) {
			return new SQL() {
				{
					SELECT("*");
					FROM("customerinfo");
					WHERE("applystatus=2");
					if (fuzzy != null || fuzzy != "") {
						WHERE("name like concat('%',#{fuzzy},'%')");
					}
				}
			}.toString()+"order by applyDate limit #{cupage},#{ofpage}";
		}	
	}
	
	// 卡种类型查询
	@Select("select * from cardtype where card_id=#{card_id}")
	Cardtype queryCardType(@Param("card_id")Integer card_id);

	// 申卡状态查询
	@Select("select * from applystatus where applyid=#{applyStatus}")
	Applystatus queryApplyStatusType(@Param("applyStatus")Integer applyStatus);

	// 获取二审数据详情
	@Select("select * from customerinfo where uuid=#{0}")
	CustomerInfo QueryCustomer(String uuid);

	// 二审完结
	@Update("update customerinfo set applystatus=applystatus+1 where uuid=#{uuid}")
	boolean UpdateCustomerType(String uuid);
}
