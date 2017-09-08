<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception</title>
</head>
<body>
	<c:if test="${not empty message}">${message}</c:if>
	<c:if test="${empty message}">잘못된 요청입니다.</c:if>
	
	<div>
		<a href="javascript:history.go(-1);">돌아가기</a>
	</div>
</body>
</html>