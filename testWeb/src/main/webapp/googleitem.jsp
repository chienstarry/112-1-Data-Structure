<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
#padding{
	padding: 0px 0px 15px 15px;
}
a {
	color: #0B173B;
	font-size: 30px;
	text-decoration: none;
}
a:hover{
text-decoration:underline;
}
.border-style {
	border-radius: 90px/90px;
}
</style>
</head>
<body>
<body style='background-color: #F4F6FF'>
<form action='${requestUri}' method='get'>

	
	<div style='position: absolute; margin-top:190px; margin-left:50px'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 0; i < orderList.length; i++) {
			String s=orderList[i][1];
		%>
		
		<a href='<%=s%>'><%=orderList[i][0]%> </a> <br><br>
		<br>
		<%
}
%>
	</div>
	<div>
		<img src="images/reading.png"
			style='position: absolute; width: 135px; height: 100px; left: 50%; top: 50%; margin-top: -285px; margin-left: -605px'>
	</div>
	
	<div>
	<input type='text' class="border-style" id="padding" name='keyword'
			style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -250px; margin-left: -400px; width: 800px; height: 25px; border-radius: 90px; border: 4px solid #ADBDFF; background: rgba(244, 246, 255, 0.70)'
			placeholder = '請輸入關鍵字' value='<%=request.getParameter("keyword")%>'/>
	</div>
	<div>
		<input type='image' src="images/magnifier.png"
			style='position: absolute; width: 28px; height: 28px; left: 50%; top: 50%; margin-top: -255px; margin-left: 368px; background: url(<path-to-image>)/ cover no-repeat; opacity: 25%; mix-blend-mode: color-burn' />
	</div>

</form>
</body>
</html>