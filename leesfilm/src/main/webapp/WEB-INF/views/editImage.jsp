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

</head>
<body>
         
<script type="text/javascript">

 function submitAction(index){
	 if (index == 1)
		 document.form.action = "/leesfilm/updatephoto";
	 if( index == 2)
		 document.form.action = "/leesfilm/deletephoto";
	 
	 document.form.submit();
	
 }
 
 window.opener.location.reload();


  </script>       
<div class="container" id="upload_container">
<table class="table table-bordered">
    <tbody>
    <%
    Object photo_id= request.getParameter("photo_id");
    System.out.println(photo_id);
    request.setAttribute("photo_id", photo_id);
    
    %>
        <form name="form" method="post" encType="multiplart/form-data">
            <% if(type == "image") { %>
            <tr>
                <th id="upload_th">사진 첨부 </th>
                <td>
                	<input id="upload_input" type="text" name="photo_real_name" />
                </td>
            </tr>
            <% } else if(type == "video") { %>
            <tr>
                <th id = "upload_th">영상 링크 </th>
                <td>
                	<input type="text" placeholder="영상 링크를 입력하세요" name="video_url" class="form-control"/>
                </td>
            </tr>
            <% } %>
            <tr>
            <input type=hidden name="photo_id" value="<%=photo_id%>">
                <td colspan="2">  
                    <input id="upload_btn" type="button" value="수정" class="pull-right" onclick='submitAction(1)'/>
                    <input id="upload_btn" type="reset" class="pull-left"/>
                   <%
               if(del == "true") {
               %>
               
                    <input id="upload_btn" type="button" value="삭제" class="pull-right" onclick='submitAction(2)'/>
                    <% } %>
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>
        </form>
    </tbody>
</table>
</div>
</body>
</html>