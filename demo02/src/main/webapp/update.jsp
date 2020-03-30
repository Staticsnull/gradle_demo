<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改理财页面</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function goBack(){
	    window.history.go(-1);  //返回上一页
	}
	//省略非空验证
	  

</script>

</head>
<body>
	<form action="update.do" method="post">
		<font size="5">修改理财信息</font><br> 
		产品代码: <input type="text" id="id" name="id" value="${product.id}" readonly="readonly" /><br> 
		风险评测：<select id="risk" name="risk">
					<option <c:if test="${product.risk==1 }">selected</c:if>
					 value="1" >R1</option>
					<option <c:if test="${product.risk==2 }">selected</c:if> 
					value="2">R2</option>
					<option <c:if test="${product.risk==3 }">selected</c:if> 
					value="3">R3</option>
				 </select> <br>
		预期收益： <input type="text" id="income" name="income"  value="${product.income }"/><br>
		发售起始日: <input type="text" id="saleStarting" name="saleStarting" value="${product.saleStarting }"/>(yyyy-MM-dd格式)<br>
		发售截止日: <input type="text" id="saleEnd" name="saleEnd" value="${product.saleEnd }"/><span>yyyy-MM-dd格式</span><br>
		产品到期日: <input type="text" id="end" name="end" value="${product.end }"/><span>yyyy-MM-dd格式</span><br>

		<input id="submit" type="submit" value="修改"> 
		<input type="button" value="返回" onclick="goBack();">
	</form>

</body>
</html>