<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
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


        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/scripts.js"></script>
  



<title>Commercial</title>
<link href="<c:url value="/resources/css/YouTubePopUp.css" />" rel="stylesheet">
<script type="text/javascript" src="jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="YouTubePopUp.jquery.js"></script>
<script type="text/javascript">
	jQuery(function(){
		jQuery("a.video").YouTubePopUp();
		//jQuery("a.bla-2").YouTubePopUp( { autoplay: 0 } ); // Disable autoplay
	});
</script>
<style>
@media (min-width: 786px) {
	
  .video-all{
    display: flex;
    flex-wrap: wrap;
    position: relative;
	margin: 0% -17% 0% 4%;
  }

  .video-all > div {
    width: 40%;
    margin: 10px;
    line-height:auto;
  }
 }
 a.video span {
		width: 100%;
		height: 100%;
		position: absolute;
		background: url("https://t1.daumcdn.net/cfile/tistory/272B024E567617E839") no-repeat;
		background-position: 50% 50%;
		background-size: 10%;
	}

	a.video span:hover {
		opacity: 0.7;
		filter: alpha(opacity=70);
	}
 	.videos .thumnail {
		width:100%;
		height:auto;
		margin : 0 0 25px 0;
	}
	a.video{
	float: left;
	position: relative;
	}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">

<body id="page-top">
<jsp:include page="header.jsp"></jsp:include>
  <div class="video-all">
  <c:forEach items="${resultList}" var="commercial">
    	<div class="videos">
				<a href="https://www.youtube.com/watch?v=${commercial}" class="video">
					<span>&nbsp;</span>
					<img class="thumnail" src="http://i1.ytimg.com/vi/${commercial}/maxresdefault.jpg" />
				</a>
    	</div>
    </c:forEach>
    </div>

</body>
<footer class="footer"></footer>
</html>
