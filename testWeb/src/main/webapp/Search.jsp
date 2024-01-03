<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
.button {
	position: absolute;
	width: 45px;
	height: 25px;
	font-size: 15px;
	left: 50%;
	top: 50%;
}

.border-style {
	border-radius: 75px/90px;
}

#padding {
	padding: 0px 0px 0px 15px;
}

.note {
	position: absolute;
	width: 50px;
	height: 50px;
	animation-timing-function: ease-in-out;
	animation-direction: alternate;
	animation-name: note;
	animation-duration: 5s;
	animation-iteration-count: infinite;
}


}
.box {
	position: relative;
}

.box:before {
	content: '';
	position: absolute;
	z-index: 2;
	top: 60px;
	left: 50px;
	width: 50px;
	height: 50px;
	border-radius: 2px;
	transform: rotate(45deg);
	-webkit-animation: box 1.25s infinite;
}

@
-webkit-keyframes box { 0%{
	top: 50px;
}

20
%
{
border-radius
:
2px;
}
50
%
{
top
:
80px;
border-bottom-right-radius
:
25px;
}
80
%
{
border-radius
:
2px;
}
100
%
{
top
:
50px;
}
}
.box:after {
	content: '';
	position: absolute;
	z-index: 1;
	top: 128px;
	left: 52px;
	width: 44px;
	height: 3px;
	background: #eaeaea;
	border-radius: 100%;
	-webkit-animation: shadow 1.25s infinite;
}

@
-webkit-keyframes shadow { 0%,100%{
	left: 54px;
	width: 40px;
	background: #eaeaea;
}
50
%
{
top
:
126px;
left
:
50px;
width
:
50px;
height
:
7px;
background
:
#eee;
}
}
body {
  background-image: url('images/backgroundPhoto.jpg');
  background-color: #FFF8F1;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
}
</style>
<script type="text/javascript">
	function click10() {
		document.getElementsByName("searchNum")[0].value = 10;
		document.getElementsByName("searchNum")[0].style.color = '#0489B1';
	}
	function click20() {
		document.getElementsByName("searchNum")[0].value = 20;
		document.getElementsByName("searchNum")[0].style.color = '#0489B1';
	}
	function click40() {
		document.getElementsByName("searchNum")[0].value = 40;
		document.getElementsByName("searchNum")[0].style.color = '#0489B1';
	}
	function click80() {
		document.getElementsByName("searchNum")[0].value = 80;
		document.getElementsByName("searchNum")[0].style.color = '#0489B1';
	}
</script>
</head>
<body style='background-color: #FFF8F1'>
	<form action='${requestUri}' method='get'>
		
		<div>
			<input type='text' class="border-style" id="padding"
				style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -92px; margin-left: -375px; width: 750px; height: 45px; border-radius: 90px; border: 4px solid #D1BCA8; background: rgba(227, 224, 219, 1); mix-blend-mode: hard-light'
				name='keyword' placeholder='請輸入關鍵字' onfocus="placeholder= '' "
				onblur="placeholder='請輸入關鍵字'" />
		</div>
		<div>
			<input type='image' src="images/magnifier.png"
				style='position: absolute; width: 28px; height: 28px; left: 50%; top: 50%; margin-top: -93px; margin-left: 343px; background: url(<path-to-image>)/ cover no-repeat; opacity: 30%; mix-blend-mode: color-burn'/>
		</div>
		<div>
			<a href='http://localhost:8080/Final_Project/TestProject'><img
				src="images/InkQC2.png"
				style='position: absolute; width: 545px; height: 140px; left: 50%; top: 50%; margin-top: -245px; margin-left: -185px'></a>
		</div>
		<div>
			<a href='http://localhost:8080/Final_Project/TestProject'><img
				src="images/InkQE.png"
				style='position: absolute; width: 665px; height: 190px; left: 50%; top: 50%; margin-top: -275px; margin-left: -420px'></a>
		</div>
	</form>
</body>
</html>