<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인
ID <input type="text" name="email">
PW <input type="password" name="pw">
<input class="btn-login" type="button" value="로그인" />
</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
$(".btn-login").on("click", function() {
	var email = $("input[name='email']").val();
	var pw = $("input[name='pw']").val();
	
	var data = {"email" : email, "pw" : pw};

	$.ajax({
		async		: true,
		type		: "post",
		url			: "/join/login",
		data		: data,
		success		: function(data){
			if (data.resultCode == 1) {
				location.href = "/join/loginComplete";
			}
		}
	});
});
</script>
</html>