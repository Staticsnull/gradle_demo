<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增理财页面</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function goBack(){
	    window.history.go(-1);  //返回上一页
	}
	$(function(){
		//验证日期的正则表达式
	    var DATE_FORMAT = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
	    $('#submit').click(function(){
	        var risk = $('#risk').val();
	        var saleStarting = $('#saleStarting').val();
	        if(risk=='0'){
	            alert('请选择区域');
	            return false;
	        }else if(!DATE_FORMAT.test(saleStarting)){
	        	//省略其他时间验证
	            alert('时间格式有误,请输入正确的格式:yyyy-MM-dd!');
	            return false;
	        }
	        return true;
	    });
	    $("#id").blur(function(){//绑定代码框改变的事件
	    	var id = $("#id").val();
	    	if(id == ""){
	    		$("#error").html("请填写代码");
	    		return;
	    	}
	    	var url = 'doFindCode.do?id='+id;
	    	//异步区域信息
	    	$.get(url,function (data) {
                if(data == "true"){
                    $("#error").html("代码不可用");
                }else{
                	$("#error").html("代码可用"); 
                }
            });
	   });
	    
	});

</script>

</head>
<body>
	<form action="add.do" method="post">
		<font size="5">新增理财信息</font><br> 
		产品代码: <input type="text" id="id" name="id" /><span id="error"></span><br> 
		风险评测：<select id="risk" name="risk">
					<option value="0">-请选择区域-</option>
					<option value="1">R1</option>
					<option value="2">R2</option>
					<option value="3">R3</option>
				 </select> <br>
		预期收益： <input type="text" id="income" name="income" /><br>
		发售起始日: <input type="text" id="saleStarting" name="saleStarting" />(yyyy-MM-dd格式)<br>
		发售截止日: <input type="text" id="saleEnd" name="saleEnd" /><span>yyyy-MM-dd格式</span><br>
		产品到期日: <input type="text" id="end" name="end" /><span>yyyy-MM-dd格式</span><br>

		<input id="submit" type="submit" value="保存">
		<input type="button" value="返回" onclick="goBack();">
	</form>

</body>
</html>