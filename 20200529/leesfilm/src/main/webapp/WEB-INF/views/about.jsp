<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%
    request.setCharacterEncoding("UTF-8");
    String id = (String)session.getAttribute("idKey");
%>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<meta name="viewport" content="width=device-width, minimum-scale=320">
<title>Seunchae's Portfolio</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic"
	rel="stylesheet" type="text/css" />
<!-- Third party plugin CSS-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
 
<!-- Bootstrap core JS-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<!-- Third party plugin JS-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script type="text/javascript">

function edit(){
	
	
    if("<%=id%>"=="이승채"){
   	 var edit_flag = confirm("이미지를 수정하겠습니까?");
   	 if(edit_flag==true){
   		window.open("./editImage","Edit Image","width=500,height=400");
   
   	 }
   	 else alert("실행 취소 되었습니다.");
    }
    
}
</script>

</head>
<body id="page-top">
	<!-- Navigation-->
	 <jsp:include page="header.jsp"></jsp:include>

	<div id="title_img">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/1.jpg" width="100%">
	</div>
	<div id="text">
		<p>Seoul to Paju</p>
		<br>
		<br>
		<p>Film</p>
		<p>Photo</p>
		<p>Video Art</p>
		<br>
		<br>
		<p>etc</p>
	</div>
	<div id="partition">
		<p>* * *</p>
	</div>

	<div id="first_img">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/2.jpg" width="100%">
	</div>
	<div id="second_img">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/3.jpg" width="100%">
	</div>
	<div id="second_img">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/4.jpg" width="100%">
	</div>

	<div id="second_row">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/5.jpg" width="100%">
	</div>
	<div id="second_second">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/6.jpg" width="100%">
	</div>
	<div id="second_second">
		<img onclick="edit()" src="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/7.jpg" width="100%">
	</div>

	<div id="instagram">
		<p>
			Follow <a id="insta" href="https://www.instagram.com/toomhme/" target="_blank">@toomhme</a>
			on Instagram
		</p>
	</div>

	<footer class="footer"> </footer>
</body>
</html>