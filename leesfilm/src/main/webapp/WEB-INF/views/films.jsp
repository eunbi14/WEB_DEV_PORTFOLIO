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
    <!--     <script src="../js/scripts.js"></script> -->
 
<title>Films</title>
<link href="<c:url value="/resources/css/YouTubePopUp.css" />" rel="stylesheet">

<script type="text/javascript" src="/leesfilm/resources/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="/leesfilm/resources/js/YouTubePopUp.jquery.js"></script>


<script type="text/javascript">
	jQuery(function(){
		jQuery("a.video").YouTubePopUp();
		//jQuery("a.bla-2").YouTubePopUp( { autoplay: 0 } ); // Disable autoplay
	});
</script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>

	body{
		height : 80%;
		background-color: #1e1918;
	}
	.video-all{
		width : 100%;
		height : 80%;
		position: absolute;
		top:100px;
		z-index:1;
	}
	#v0 { float: left; width: 40%;
			margin: 11% 0% 4% 8%;
			 }

	#v1 { float: left; width: 40%;
			margin: 11% 0% 0% 4%;
			}


	.videos img {
		width:100%;
		height:auto;
	}


	a.video {
		float: left;
		position: relative;
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

	@media screen and (max-width: 480px) {
		a.video span {
			background-size: 20%;
		}
	}


	@media (max-width: 640px) {
		#v0 {
			clear: left;
			width: 90%;
			margin: 11% 0% 4% 5%;
		}
		#v1 {
			clear: left;
			width: 90%;
			margin: 11% 0% 4% 5%;
		}
	}



</style>
</head>
<body id="page-top">
 <jsp:include page="header.jsp"></jsp:include>


	<div class="video-all">	
		<div class="videos" id="v0">
			<c:forEach items="${resultList}" var="films">
				<a href="https://www.youtube.com/watch?v=${films}" class="video" >
					<span>&nbsp;</span>
					<img src="http://i1.ytimg.com/vi/${films}/maxresdefault.jpg" />
				</a>
			</c:forEach>
		</div>
	</div>

</body>
</html>
