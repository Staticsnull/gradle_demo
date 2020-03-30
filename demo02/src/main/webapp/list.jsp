<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风险评级 产品代码</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function delProduct(id){
		var result = window.confirm("确认要删除该理财信息吗");
		if(result){
			var url = "del.do?id="+id;
			$.getJSON(url,function(data){//success
				if(data[0].success == "true"){//成功
					window.location.href = "index.do";
	            }else{
	            	alert("系统繁忙,删除失败"); 
	            }
			});
		}
		
	}
</script>
</head>
<body>
	<div>
		<form action="index.do" method = "post">
		
			产品代码 : <input type="text" name="id" value="${id }">
			风险评级 : <select name="risk">
					<option value="">请选择</option>
					<option <c:if test="${risk==1 }">selected</c:if>
					 value="1">R1</option>
					<option <c:if test="${risk==2 }">selected</c:if> 
					value="2">R2</option>
					<option <c:if test="${risk==3 }">selected</c:if> 
					value="3">R3</option>
			</select>
			<input type="submit" value="查询">
			<a href="toAdd.do">新增理财信息</a>
			
			<table style="margin-top:30px;" id="product" border="1">
				<tr>
					<th>产品代码</th>
					<th>风险评级</th>
					<th>预期收益</th>
					<th>发售起始日</th>
					<th>发售截止日</th>
					<th>发售到期日</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list }" var="product" varStatus="status">
				<tr  style="background-color: ${status.index%2==0?'grey':''}">
					<td>${product.id }</td>
					<c:if test="${product.risk==1 }"><td> R1 </td></c:if>
					<c:if test="${product.risk==2 }"><td> R2 </td></c:if>
					<c:if test="${product.risk==3 }"><td> R3 </td></c:if>
					<td>${product.income }</td>
					<td>${product.saleStarting }</td>
					<td>${product.saleEnd }</td>
					<td>${product.end }</td>
					<td>
					<a href="toUpdate.do?id=${product.id }" >修改</a>
					<a href="#" onclick="delProduct(${product.id});" >删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>