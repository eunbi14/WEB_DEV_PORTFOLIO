<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<%
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("idKey");
%>
    <head>
   <link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/commercial.css?after" />"
	rel="stylesheet">
	<title>Films</title>
<link href="<c:url value="/resources/css/YouTubePopUp.css" />" rel="stylesheet">

<script type="text/javascript" src="jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="YouTubePopUp.jquery.js"></script>

<script type="text/javascript">
jQuery(function() {
	$(document).on("click", "a.video", function() {
		//var path = $(this).attr('src')
		
		if("<%=id%>" == "이승채"){
			var result = confirm("동영상을 수정/삭제하겠습니까?");
			if(result){
				<%
				session.setAttribute("delete","true");
				session.setAttribute("type","video");
				%>
				window.open("./editImage","Edit Image","width=500,height=500");
			}else{
				alert("실행 취소 되었습니다.");
			}
		}
		else{
			jQuery("a.video").YouTubePopUp();
		}	
		
	});
	
	//jQuery("a.bla-2").YouTubePopUp( { autoplay: 0 } ); // Disable autoplay
});
</script>

</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
	<div class="video-all">	
		<c:forEach items="${resultList}" var="films">
			<div class="videos" id="v0">
				<a href="https://www.youtube.com/watch?v=${films}" class="video" >
					<span>&nbsp;</span>
					<img src="http://i1.ytimg.com/vi/${films}/maxresdefault.jpg" />
				</a>
			</div>
		</c:forEach>
	</div>
<footer class="footer"></footer>
</body>
</html>
