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
		<div class="column">
      		<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
				<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
				<c:forEach items="${resultMap}" var="photoMap">
					<c:set var="photo_id" value="${photoMap.key}" />
					<c:set var="photosrc" value="${gd}${photoMap.value}" />
					<img src="${photosrc}" width="300px" title="${photo_id}"/>
				</c:forEach>
   		</div>
   	</div>
<footer class="footer"></footer>   	
</body>
</html>