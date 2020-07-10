<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%
   request.setCharacterEncoding("UTF-8");
   String del = (String)session.getAttribute("delete");
   String type = (String)session.getAttribute("type");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upload Images/Videos</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link href="<c:url value="/resources/css/styles.css?after" />" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript">
     window.onload= function(){
        var delete_photo_id = window.location.search;
        console.log(delete_photo_id);
     }
     
</script>       
</head>
<body>
<script type="text/javascript">
 function submitPhoto(index){
	 if (index == 1)
		 document.form.action = "/leesfilm/updatephoto";
	 if( index == 2)
		 document.form.action = "/leesfilm/deletephoto";
	 
	 document.form.submit();
	
 }
 function submitFilms(index){
	 if (index == 1)
		 document.form.action = "/leesfilm/updatefilm";
	 if( index == 2)
		 document.form.action = "/leesfilm/deletefilm";
	 
	 document.form.submit();
	
 }
 function submitComme(index){
	 if (index == 1)
		 document.form.action = "/leesfilm/updatecomme";
	 if( index == 2)
		 document.form.action = "/leesfilm/deletecomme";
	 
	 document.form.submit();
	
 }
  </script>       
<div class="container" id="upload_container">
   <form id="form" name="form" method="post" enctype="multipart/form-data">
      <table class="table table-bordered">
       <tbody>
        <%
    Object photo_id= request.getParameter("photo_id");
    Object film_id = request.getParameter("film_id");
    Object comme_id = request.getParameter("comme_id");

    %>
        <form name="form" method="post" encType="multiplart/form-data">
        
            <% if(type == "image") { %>
            <tr>
                <th id="upload_th">사진 첨부 </th>
                <td>
                <input type="text" placeholder="이미지 링크를 입력하세요" id="upload_file" name="photofile" id="photoImg" class="form-control" /></td>
            </tr>
            <% } else if(type == "films") { %>
            <tr>
                <th id = "upload_th">영상 링크 </th>
                <td><input type="text" placeholder="영상 링크를 입력하세요" name="video_film_url" class="form-control" /></td>
            </tr>
             <% } else if(type == "comme") { %>
            <tr>
                <th id = "upload_th">영상 링크 </th>
                <td><input type="text" placeholder="영상 링크를 입력하세요" name="video_comme_url" class="form-control" /></td>
            </tr>
            <% } %>
            <tr>
             <input type=hidden name="photo_id" value="<%=photo_id%>">
             <input type=hidden name="film_id" value="<%=film_id%>">
             <input type=hidden name="comme_id" value="<%=comme_id%>">
                <td colspan="2">
                <% if(type=="image") {%>
                   <input id="upload_btn" type="button" value="수정" class="pull-right" onclick='submitPhoto(1)'/>
                   <input id="upload_btn" type="reset" class="pull-left"/>
	                   <%
	                   if(del == "true") {
	                   %>
	                  <input id="upload_btn" type="button" value="삭제" class="pull-right" onclick='submitPhoto(2)'/>
	                    <% } %>
	              <% } else if (type == "films") {%>
	              	<input id="upload_btn" type="button" value="수정" class="pull-right" onclick='submitFilms(1)'/>
                  	<input id="upload_btn" type="reset" class="pull-left"/>
	                   <%
	                   if(del == "true") {
	                   %>
	                  <input id="upload_btn" type="button" value="삭제" class="pull-right" onclick='submitFilms(2)'/>
	              	<% } %>
	              <% } else if (type == "comme") {%>
						<input id="upload_btn" type="button" value="수정" class="pull-right" onclick='submitComme(1)'/>
                  	<input id="upload_btn" type="reset" class="pull-left"/>
	                   <%
	                   if(del == "true") {
	                   %>
	                  <input id="upload_btn" type="button" value="삭제" class="pull-right" onclick='submitComme(2)'/>
	              	<% } %>
	              <%} %>
                </td>
            </tr>
       </tbody>
       </table>
    </form>
</div>
</body>
</html>