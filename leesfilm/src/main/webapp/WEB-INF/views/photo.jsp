<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="<c:url value="/resources/css/styles.css" />"
   rel="stylesheet">
<link href="<c:url value="/resources/css/photo.css" />"
   rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(e) {

      $(document).on("click", "img", function() {
         var path = $(this).attr('src')
         var photo_id=$(this).attr('title')
         console.log(photo_id);
         
         if(path=="https://raw.githubusercontent.com/eunbi14/WEB_DEV_PORTFOLIO/master/done/images/top.png"){
             window.scrollTo(0,0);
              return;
          }
         if("<%=id%>" == "이승채") {
            var result = confirm("이미지를 수정/삭제하겠습니까?");
            if(result){
               <%
               session.setAttribute("delete","true");
               session.setAttribute("type","image");
               %>

               window.open("./editImage?photo_id="+photo_id,"Edit Image","width=500,height=500");
            	
            }else{
               alert("실행 취소 되었습니다.");
            }
         }
         else{
            showImage(path);
         }   
         
      });

      function showImage(fileCallPath) {

         $(".bigPictureWrapper").css("display", "flex").show();

         $(".bigPicture").html("<img src='"+fileCallPath+"' >").animate({
            width : '100%',
            height : '100%'
         }, 1000);
      }

      $(".bigPictureWrapper").on("click", function(e) {
         $(".bigPicture").show(1000);
         setTimeout(function() {
            $('.bigPictureWrapper').hide();
         }, 200);
      });      
   });
   
   
</script>

<title>Photo</title>
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
  
   <div class='bigPictureWrapper'>
      <div class='bigPicture'></div>
   </div>
   <div class="row">
<% int i = 1; %>
   <c:forEach items="${resultMap}" var="photoMap">
   <c:choose>

	<c:when test="${i%2 ne 0}">	
		   	
      		<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
				<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
				
					<c:set var="photo_id" value="${photoMap.key}" />
					<c:set var="photosrc" value="${gd}${photoMap.value}" />
					<img class="column" src="${photosrc}" width="100%" title="${photo_id}"/>
   	</c:when>
   	
 
	<c:otherwise>

      		<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
				<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
				
					<c:set var="photo_id" value="${photoMap.key}" />
					<c:set var="photosrc" value="${gd}${photoMap.value}" />
					<img class="column" src="${photosrc}" width="100%" title="${photo_id}"/>

   	</c:otherwise>
   	</c:choose>
   	
   	<% i++; %>
   	
   	</c:forEach>
   	</div>
</body>

<footer class="footer"></footer>
</html>