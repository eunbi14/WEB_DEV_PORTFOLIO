<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Example Photo Insert</title>

<script type="text/javascript">

function validate(){
	var category=$("#category").val();
	var content =$("#address").val();
	
	if(!category){
		alert("카테고리가 뭐에요?");
		$("#category").focus();
		return false;
	}
	else if(!address){
		alert("이미지 주소는 뭔가요 ?");
		$("#address").focus();
		return false;
	}else{
		addThing(category, address);
	}
}

function addThing(cat,addr){
	$.ajax({
		url:"/jquery/PhotoInsert",
		type:'POST',
		data:{
			category : cat,
			address : addr
		},
		success:function(data){
			if(data==1){
				alert("사진 등록이 완료되었습니다.");
			}else{
				alert("사진 등록 실패");
			}
		}, error:function(){
			console.log("error");
		}
	})
}
</script>
</head>
<body>

<input type="text" placeholder="카테고리" id="category" />
<input type="text" placeholder="이미지 주소 " id="address" />

<input type="button" value="등록" onclick="validate()" />
</body>
</html>