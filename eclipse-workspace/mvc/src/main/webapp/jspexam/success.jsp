<%@page import="model.domain.TimeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		text-align: center;
	}
</style>
</head>
<body>
<% TimeVO vo = (TimeVO)request.getAttribute("time"); %>
<h2>"${ time.hour }시 ${ time.minute }분에 당첨!! 추카추카"</h2>
<img src="https://i.pinimg.com/564x/af/8c/cc/af8ccc4ed25e03eeadf362f712790f4c.jpg">
</body>
</html>