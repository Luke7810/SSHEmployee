<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>List all Employee</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$alertDiv = $(":input[name=lastname]");
			$(":input[name=lastname]").change(function() {
				var lastnameval = $(this).val();
				if($.trim(lastnameval) != ""){
					$(this).next("font").remove();
					var url = "emp-validateLastName";
					var args = {"lastname":$.trim(lastnameval),  "args":Math.random()};
					$.post(url,args,function(data) {
						if(data=="1"){
							$alertDiv.after("<font color='green'>Name is OK!</font>");
						}else if(data == "0"){
							$alertDiv.after("<font color='red'>Name is NOT OK!</font>");
						}else{
							alert("Server has some problem!");
						}
					});
				}
			});
		});
	</script>
  </head>
  
  <body>
    <h4>Add New Employee</h4>
    <s:debug></s:debug>
    <s:form action="emp-save" method="post">
    	<s:textfield name="lastname" label="Last Name: "></s:textfield>
    	<s:hidden name="id"></s:hidden>
    	<s:textfield name="email" label="E-Mail: "></s:textfield>
    	<s:textfield name="birth" label="Birthday: "></s:textfield>
    	<s:select list="deps" listKey="id" listValue="depName" name="department.id" label="Department: "></s:select>
    	<s:submit></s:submit>
    	<s:reset></s:reset>
    </s:form>
    
  </body>
</html>
