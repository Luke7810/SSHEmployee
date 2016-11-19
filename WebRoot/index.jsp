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
			$(".delete").click(function () {
				var empName = $(this).parent().parent().children().next().html();
				var $tr = $(this).parent().parent();
				var flag = confirm("Do you want to delete emp: "+empName+" ?");
				if(flag){
					var url = this.href;
					var args = {"":""};
					$.post(url,args,function(data){
						if(data=="1"){
							alert("Delete is success!");
							$tr.remove();
						}else{
							alert("Delete fail !");
						}
					})
				}
				return false;
			})
		})
	
	</script>
  </head>
  
  <body>
    <s:if test="epms==null || epms.size()==0">
    	<h4>没有员工信息！</h4>
    </s:if>
    <s:else>
    	<h4>员工信息</h4>
    	<table border="1">
    		<tr>
    			<td>ID</td>
    			<td>Employ Name</td>
    			<td>Employ E-Mail</td>
    			<td>Birth</td>
    			<td>Department Name</td>
    			<td>DELETE</td>
    			<td>Edit</td>
    		</tr>
    		
    		<s:iterator value="epms">
    			<tr>
    				<td>${id}</td>
    				<td>${lastname}</td>
    				<td>${email}</td>
    				<td>
						<s:date name="birth" format="yyyy-MM-dd"/>
					</td>
    				<td>${department.getDepName()}</td>
    				<td><a href="emp-delete?emp_id=${id}" class="delete">delete</a></td>
    				<td><a href="emp-input?emp_id=${id}" >edit</a></td>
    			</tr>
    		</s:iterator>
    		
    	</table>
    </s:else>
    <a href="emp-input">Add a new employee</a>
  </body>
</html>
