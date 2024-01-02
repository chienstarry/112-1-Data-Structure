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

@
keyframes note { 0%{
	left: 640px;
	top: 0px;
}

25
%
{
left
:
700px;
top
:
60px;
}
50
%
{
left
:
760px;
top
:
0px;
}
75
%
{
left
:
700px;
top
:
-60px;
}
100
%
{
left
:
640px;
top
:
0px;
}
}
.note1 {
	position: absolute;
	width: 50px;
	height: 50px;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
	animation-name: note1;
	animation-duration: 5s;
	animation-iteration-count: infinite;
}

@
keyframes note1 { 0%{
	left: 760px;
	top: 0px;
}

25
%
{
left
:
700px;
top
:
-60px;
}
50
%
{
left
:
640px;
top
:
0px;
}
75
%
{
left
:
700px;
top
:
60px;
}
100
%
{
left
:
760px;
top
:
0px;
}
}
.note2 {
	position: absolute;
	width: 50px;
	height: 50px;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
	animation-name: note2;
	animation-duration: 5s;
	animation-iteration-count: infinite;
}

@
keyframes note2 { 0%{
	left: 700px;
	top: -60px;
}

25
%
{
left
:
640px;
top
:
0px;
}
50
%
{
left
:
700px;
top
:
60px;
}
75
%
{
left
:
760px;
top
:
0px;
}
100
%
{
left
:
700px;
top
:
-60px;
}
}
.note3 {
	position: absolute;
	width: 50px;
	height: 50px;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
	animation-name: note3;
	animation-duration: 5s;
	animation-iteration-count: infinite;
}

@
keyframes note3 { 0%{
	left: 700px;
	top: 60px;
}

25
%
{
left
:
760px;
top
:
0px;
}
50
%
{
left
:
700px;
top
:
-60px;
}
75
%
{
left
:
640px;
top
:
0px;
}
100
%
{
left
:
700px;
top
:
60px;
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
<body style='background-color: #F4F6FF'>
	<form action='${requestUri}' method='get'>

		<div class='box'
			style='position: absolute; margin-top: 530px; margin-left: 635px;'></div>

		<div>
			<input type='text' class="border-style" id="padding"
				style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -47px; margin-left: -400px; width: 800px; height: 45px; border-radius: 90px; border: 4px solid #ADBDFF; background: rgba(244, 246, 255, 0.70)'
				name='keyword' placeholder='請輸入關鍵字' onfocus="placeholder= '' "
				onblur="placeholder='請輸入關鍵字'" />
		</div>
		<div>
			<input type='image' src="images/magnifier.png"
				style='position: absolute; width: 28px; height: 28px; left: 50%; top: 50%; margin-top: -48px; margin-left: 368px; background: url(<path-to-image>)/ cover no-repeat; opacity: 25%; mix-blend-mode: color-burn'/>
		</div>
		<div>
			<a href='http://localhost:8080/Final_Project/TestProject'><img
				src="images/reading.png"
				style='position: absolute; width: 250px; height: 190px; left: 50%; top: 50%; margin-top: -275px; margin-left: -140px'></a>
		</div>
	</form>
</body>
</html>