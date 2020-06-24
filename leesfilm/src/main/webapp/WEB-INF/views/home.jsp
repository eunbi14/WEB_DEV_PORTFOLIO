<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" />

<script type="text/javascript">
	function edit() {
		<%
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("idKey");
		if(id == "이승채"){ %>
			var result = confirm("이미지를 수정하겠습니까?");
			if(result){
				<% 
				session.setAttribute("delete","false"); 
				session.setAttribute("type", "image");
				%>
				window.open("./editImage","Edit Image","width=500,height=500");
			}else{
				alert("실행 취소 되었습니다.");
			}
		<%}%>
	}		
</script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="title_img">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/1.jpg" width="100%" onclick="edit()">
	</div>
	<div id="text">
		<p>Seoul to Paju</p>
		<br> <br>
		<p>Film</p>
		<p>Photo</p>
		<p>Video Art</p>
		<br> <br>
		<p>etc</p>
	</div>
	<div id="partition">
		<p>* * *</p>
	</div>

	<div id="first_img">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/2.jpg" width="100%" onclick="edit()">
	</div>
	<div id="second_img">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/3.jpg" width="100%" onclick="edit()">
	</div>
	<div id="second_img">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/4.jpg" width="100%" onclick="edit()">
	</div>

	<div id="second_row">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/5.jpg" width="100%" onclick="edit()">
	</div>
	<div id="second_second">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/6.jpg" width="100%" onclick="edit()">
	</div>
	<div id="second_second">
		<img src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/7.jpg" width="100%" onclick="edit()">
	</div>

	<div id="instagram">
		<p>
			Follow <a id="insta" href="https://www.instagram.com/toomhme/" target="_blank">@toomhme</a>
			on Instagram
		</p>
	</div>
	<footer class="footer"></footer>
</body>
</html>