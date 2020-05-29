<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cPath = request.getContextPath();
	session.setAttribute("idKey", "이승채");
	String url = cPath + "/about";
	String msg = "관리자 모드로 로그인합니다.";
%>

<script type="text/javascript">
	alert("<%=msg%>");
	top.document.location.reload();
	location.href = "<%=url%>";
</script>
