<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="gd" value="http://drive.google.com/uc?export=view&amp;id="/>
<c:forEach items="${resultList}" var="photo">
	<c:set var="photosrc" value="${gd}${photo}" />
	<img src="${photosrc}" width="300px"/>
</c:forEach>

</body>
</html>