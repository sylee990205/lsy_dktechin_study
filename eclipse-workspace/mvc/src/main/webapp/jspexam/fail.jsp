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
<h2>"${ time.hour }시 ${ time.minute }분에 당첨 실패!! 아쉽아쉽"</h2>
<img src="https://i.pinimg.com/564x/70/83/7b/70837b3198ba6f46462f7295399da621.jpg"><br>
<a href='<%= request.getHeader("referer") %>'>로또 응모 링크</a>
</body>
</html>