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
body {
  background-image: url('images/SearchResult.png');
  background-color: #FFF8F1;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
}
</style>
</head>
<body>
<body style='background-color: #FFF8F1'>
<form action='${requestUri}' method='get'>
	
	<div style='font-size: 80%; color: #503922; position: absolute; margin-top:170px; margin-left:150px'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 0; i < orderList.length; i++) {
			String s=orderList[i][1];
		%>
		
		<a href='<%=s%>' style='font-size: 200%; color: #362717'><%=orderList[i][0]%> </a> <br><br>
		<br>
		<%
}
%>
	</div>
	<div>
		<img src="images/InkQC2.png"
			style='position: absolute; width: 300px; height: 77px; left: 50%; top: 50%; margin-top: -235px; margin-left: -670px'>
	</div>
	<div>
		<img src="images/InkQE.png"
			style='position: absolute; width: 465px; height: 125px; left: 50%; top: 50%; margin-top: -305px; margin-left: -750px'>
	</div>
	<div>
	<input type='text' class="border-style" id="padding" name='keyword'
			style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -245px; margin-left: -400px; width: 750px; height: 30px; border-radius: 90px; border: 4px solid #D1BCA8; background: rgba(227, 224, 219, 1)'
			placeholder = '請輸入關鍵字' value='<%=request.getParameter("keyword")%>'/>
	</div>
	<div>
		<input type='image' src="images/magnifier.png"
			style='position: absolute; width: 28px; height: 28px; left: 50%; top: 50%; margin-top: -247px; margin-left: 318px; background: url(<path-to-image>)/ cover no-repeat; opacity: 30%; mix-blend-mode: color-burn' />
	</div>

</form>
</body>
</html>