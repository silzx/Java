<%@page import="java.net.URLDecoder"%>
<%@page import="com.wzx.util.FenYe"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="buttons/buttons.css">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
input[name='exit'] {
	position: fixed;
	right: 200px;
	height: 200px
}
</style>
</head>
<body>
	<script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
	<center>
		<div class="jumbotron">
			<h2>欢迎&nbsp;${emp.ename }${emp.power.pname }&nbsp;登录</h2>
		</div>
		<div>
		 	<form action="<%=basePath%>info/query" method="post" id="reset" class="form-search" name="changePage">
				员工姓名：
				<input type="text" name="ename" class="input-medium search-query" value="${ename }">&nbsp;&nbsp;
				员工年龄：
				<input type="text" name="minAge" class="input-medium search-query" value="${minAge }">~
				<input type="text" name="maxAge" class="input-medium search-query" value="${maxAge }">&nbsp;&nbsp;
				员工部门：
				<select name="dept">
					<option>--请选择--</option>
					<c:choose>
					<c:when test="${emp.pid==5 }">
						<c:if test="${dept=='' }">
							<c:forEach items="${depts }" var="d">
								<option value="${d.did }" >${d.dname }</option>
							</c:forEach>
						</c:if>
						<c:if test="${dept!='' }">
							<c:forEach items="${depts }" var="d">
								<c:if test="${dept==d.did }">
									<option value="${d.did }" selected="selected">${d.dname }</option>
								</c:if>
								<c:if test="${dept!=d.did }">
									<option value="${d.did }" >${d.dname }</option>
								</c:if>
							</c:forEach>
						</c:if>
					</c:when>
					<c:otherwise>
						<option value="${emp.did }" selected="selected">${emp.dept.dname }</option>
					</c:otherwise>
					
					</c:choose>
				<input type="hidden" value="<%=FenYe.page %>" name="page" /> 
				<input type="hidden" value="<%=FenYe.pageCount %>" name="pageCount" />					
				</select>
				<button type="submit" class="button button-action  button-rounded button-small">搜索</button>
				<a href="javascript:reset()"><input type="button" class="button button-square  button-rounded button-small" value="重置"></a>
				<a href="emp/exit"><input type="button" class="button button-highlight button-rounded button-small" value="退出"> </a>
			</form>
		</div>
		<div class="row">
			<form action="info/del" method="post">
				<table border="0" class="table table-striped table-hover ">
					<tr align="center">
						<c:if test="${emp.pid != 1 }">
							<td><input type="checkbox" name="selAll"
							style="display: none;"> <input type="button"
							class="btn btn-warning" value="全选" onclick="aclick()"></td>
						</c:if>
						<td>员工编号</td>
						<td>员工头像</td>
						<td>员工姓名</td>
						<td>员工性别</td>
						<td>员工年龄</td>
						<td>员工部门</td>
						<td>权限</td>
						<td>员工注册日期</td>
						<td>修改时间</td>
						<!-- 普通用户看不到操作按钮 -->
						<c:if test="${emp.pid != 1 }">
							<td>删除</td>
						</c:if>
						<td>修改</td>
					</tr>
				<c:forEach items="${emps }" var="em" varStatus="status">
					<tr align="center">
					<c:if test="${emp.pid != 1 }">
					<td><input type="checkbox" name="ids" value="${em.eid }"></td>
					</c:if>
					<td>${status.count }</td>
					<td><a href="../img/${em.pic }"><img style="width:192px;height: 108px" alt="无法显示" src="../img/${em.pic }" class="img-rounded"></a></td>
					<td>${em.ename }</td>
					<c:choose>
						<c:when test="${em.esex eq 0}">
							<td>女</td>
						</c:when>
						<c:otherwise>
							<td>男</td>
						</c:otherwise>
					</c:choose>
					<td>${em.eage }</td>
					<td>${em.dept.dname }</td>
					<td>${em.power.pname }</td>
					<%-- <td>${em.dname }</td>
					<td>${em.pname }</td> --%>
					<td><fmt:formatDate value="${em.joindate }" pattern="yyyy年MM月dd日" /></td>
					<td><fmt:formatDate value="${em.modify }" pattern="yyyy年MM月dd日" /></td>
					<c:if test="${emp.pid != 1 }">
					<td><a href="info/del?ids=${em.eid }"><input
							type="button"
							class="button button-3d button-caution button-small"
							value="删除"></a></td>
					</c:if>
					<td><a href="info/toUpdate?ids=${em.eid }"><input
							type="button"
							class="button button-3d button-primary button-small"
							value="修改"></a></td>
				</tr>
				</c:forEach>

				</table>
				<c:if test="${emp.pid != 1 }">
				<div class="button-group">
					<button type="submit"
						class="button button-royal button-rounded button-raised"
						onclick="return confirm('是否删除？')">删除选中</button>
					<button type="button"
						class="button button-royal button-rounded button-raised"
						onclick="location.href='add.jsp'">添加员工</button>
				</div>
				</c:if>
				<p>
				<p>
				<div>
					<a href="javascript:firstPage()"><input type="button"
						class="button button-border button-inverse button-small"
						value="首页"></a>&nbsp;&nbsp; <a
						href="javascript:previousPage()"><input type="button"
						class="button button-border button-inverse button-small"
						value="上一页"></a>&nbsp;&nbsp; <a href="javascript:nextPage()"><input
						type="button"
						class="button button-border button-inverse button-small"
						value="下一页"></a>&nbsp;&nbsp; <a href="javascript:lastPage()"><input
						type="button"
						class="button button-border button-inverse button-small"
						value="尾页"></a>&nbsp;&nbsp;
				</div>
				<div><%=FenYe.page %>/<%=FenYe.pageCount %>页</div>
			</form>
		</div>
	</center>
	<script type="text/javascript">
		var isCheck = false;
		function aclick() {
			if (isCheck) {
				isCheck = false;
				$("input[name='selAll']").attr("checked", false);
			} else {
				isCheck = true;
				$("input[name='selAll']").attr("checked", "checked");
			}
			if ($("input[name='selAll']").attr("checked")) {
				$("input[name='ids']").attr("checked", "checked");
			} else {
				$("input[name='ids']").attr("checked", false);
			}
		}

		function reset() {
			$("input[name='ename']").val("");
			$("input[name='dept']").val("");
			location.href = "info/query";
		}

		function firstPage() {
			$("input[name='page']").val(1);
			$("form[name='changePage']").submit();
		}

		function nextPage() {
			var page = $("input[name='page']").val();
			page = parseInt(page);
			var pageCount = $("input[name='pageCount']").val();
			pageCount = parseInt(pageCount);
			if (page >= pageCount) {
				alert("已经是最后一页");
			} else {
				$("input[name='page']").val(page + 1);
				$("form[name='changePage']").submit();
			}
		}

		function previousPage() {
			var page = $("input[name='page']").val();
			page = parseInt(page);
			if (page == 1) {
				alert("已经是第一页");
			} else {
				$("input[name='page']").val(page - 1);
				$("form[name='changePage']").submit();
			}
		}

		function lastPage() {
			var page = $("input[name='page']").val();
			page = parseInt(page);
			var pageCount = $("input[name='pageCount']").val();
			pageCount = parseInt(pageCount);
			$("input[name='page']").val(pageCount);
			$("form[name='changePage']").submit();
		}
	</script>
</body>
</html>
