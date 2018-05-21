<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<style type="text/css">
#content {
	text-align: center;
}
</style>
</head>
<body>
<script src="js/lib/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/lib/bootstrap.css">
<script src="js/lib/bootstrap.js"></script>
<button id="getRange" href="">123121</button>

</body>
</html>