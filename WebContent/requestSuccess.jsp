<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<title>申請完了</title>

</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<!--
<style scoped>
    body{
    background-color: #FFF0F5;
    }
    </style>
    <!--背景色の変更-->

	<form method="POST" accept-charset="UTF-8">
		<h1>
			<font color="#808080">以下の内容で申請が完了しました。</font>
		</h1>
		備品ID:<%=request.getParameter("bihinID")%><br> 備品名:<%=request.getAttribute("bihinName")%><br>
		返却日:<%=request.getAttribute("returnDay")%><br>

	</form>

</body>
</html>