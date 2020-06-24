<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
    <head>
       
        <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/contact.css" />" rel="stylesheet">
        
       <!-- <link type="text/css" href="css/styles.css" rel="stylesheet" /> -->
        <script type="text/javascript">
   function loginCheck() {
      if (document.infoForm.name.value == "") {
         alert("이름을 입력해 주세요.");
         document.infoForm.name.focus();
         return;
      }
      if (document.infoForm.email.value == "") {
         alert("이메일을 입력해 주세요.");
         document.infoForm.email.focus();
         return;
      }
      if (document.infoForm.message.value == "") {
         alert("내용을 입력해 주세요.");
         document.infoForm.message.focus();
         return;
      }
      
      if(document.infoForm.name.value=="이승채"
            &&document.infoForm.email.value=="lee961218@naver.com"
            &&document.infoForm.message.value=="Vndtjs14!"){
               document.infoForm.action = "/leesfilm/login";
               document.infoForm.submit();
      }
      else{
         document.infoForm.action = "/leesfilm/email";
         document.infoForm.submit();
      }
     
   }
</script>
</head>

<body>
   <jsp:include page="header.jsp"></jsp:include>

   <div class="contact">
         <div class="about_head">
         <h1>Contact Me</h1>
         </div>
         <div class = "about_left">
            <h2>Get In<br>Touch</h2>
            <p>lee961218@naver.com</p>
            <p>Instagram <a id="insta" href="https://www.instagram.com/toomhme/">@toomhme</a></p>
         </div>

         <div class = "about_right">
            <form name="infoForm" method="POST">
            <p><input class="info_input" type="text" name="name" placeholder="Name" style="z-index:4;"/></p>
            <p><input class="info_input" type="email" name="email" placeholder="Email Address" style="z-index:5;"/></p>
            <p><input class="info_input" type="text" name="message" placeholder="Message" style="z-index:6;"></p>
            <input class="info_send" type="button" value="Send Message" onclick="loginCheck()"/>
            </form>
         </div>
   </div>
   <footer class="footer"></footer>
</body>
</html>