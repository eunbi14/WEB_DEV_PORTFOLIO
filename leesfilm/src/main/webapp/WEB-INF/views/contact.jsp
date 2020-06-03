<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta name="viewport" content="width=device-width, minimum-scale=320">
        <title>Seunchae's Portfolio</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- Third party plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
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

<body id="page-top">
        <!-- Navigation-->
      <jsp:include page="header.jsp"></jsp:include>

        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    
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
</body>
<footer class="footer"></footer>
</html>