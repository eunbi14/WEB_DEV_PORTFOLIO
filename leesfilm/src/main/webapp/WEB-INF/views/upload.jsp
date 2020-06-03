<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
     request.setCharacterEncoding("UTF-8");
     String id = (String)session.getAttribute("idKey");
     if(id!="이승채"){
    	 %>
<script>
    	 alert("관리자모드로 로그인해주세요!");
    	 location.href="/leesfilm/about";
</script>
<%
     }
     
    	 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upload Images/Videos</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script type="text/javascript">
// 대분류
var firstList = new Array("Photo", "Commercial", "Films");

// 중분류

var secondList1 = new Array("소분류를 선택하세요.","Photo1","Photo2","Photo3","소분류 추가");
var secondList2 = new Array("소분류를 선택하세요.","Commercial1","Commercial2","Commercial3","소분류 추가");
var secondList3 = new Array("소분류를 선택하세요.","소분류 추가");
  
// 페이지 로딩시 자동 실행  
window.onload = function(){
    var v_sidoSelect = document.getElementById("sidoSelect"); // SELECT TAG
      
    for (i =0 ; i<firstList.length; i++){// 0 ~ 3 
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");
  
        // option태그에 value 속성 값으로 저장
        optionEl.value = firstList[i];
      
        // text 문자열을 새로 생성한 <option> 태그의 값으로 추가
        optionEl.appendChild (document.createTextNode(firstList[i]));
      
        // 만들어진 option 태그를 <select>태그에 추가
        v_sidoSelect.appendChild(optionEl);
    }
  
    var v_gugunSelect = document.getElementById("gugunSelect"); // SELECT TAG
    v_gugunSelect.style.display = "none";  // 태그 감추기
  
}

// 대분류 선택시
function changeSidoSelect(){
    var v_sidoSelect = document.getElementById("sidoSelect"); // SELECT TAG
    var idx = v_sidoSelect.options.selectedIndex;     // 선택값 0 ~ 3
     

    if (idx < 1 && idx > 3){
        return;
    }
 	  gugunSelectFill(idx);   // 중분류 생성
}


function gugunSelectFill(idx){
    var v_gugunSelect = document.getElementById("gugunSelect"); // SELECT TAG
 
    var data = null;
  
    if (idx == 1){ //대분류 photo 일 때, 생기는 소분류 secondList1
    	//db 에는 소분류 카테고리만 전달 
     data = secondList1
   
     }
    if (idx == 2){
     data = secondList2
     
     }
    if (idx == 3) data = secondList3;
  

    v_gugunSelect.innerHTML = "";  // 태그 출력
      
    for (i =0 ; i<data.length; i++){ 
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");
  
        // value 속성 태그에 저장
        optionEl.value = data[i];
      
        // text 문자열을 새로 생성한 <option> 태그에 추가
        optionEl.appendChild (document.createTextNode(data[i]));
      
        // 만들어진 option 태그를 <select>태그에 추가
        v_gugunSelect.appendChild(optionEl);
    }
  
v_gugunSelect.style.display = ""; // 중분류 태그 출력
}

// 대분류 선택시
function changeSecondSelect(){
    var v_sidoSelect = document.getElementById("sidoSelect"); // SELECT TAG
    var v_secondSelect = document.getElementById("gugunSelect"); // SELECT TAG
    var idx = v_sidoSelect.options.selectedIndex; 

    if (idx < 0 && idx > 2){
        return;
    }
}

</script>

</head>
<body>
<div class="container" id="upload_container">
<form id="form" name="form" method="post" enctype="multipart/form-data">

	<table class="table table-bordered">
    <tbody>
     <tr>
	    <th id="upload_th">카테고리 </th>
	    <td>
	    <div id="sido">
	               	
			    <select id="sidoSelect" onChange="changeSidoSelect();">
			        <option value="">대분류를 선택하세요.</option>
			    </select>
			  
			    <select id="gugunSelect" onChange="changeSecondSelect();">
			        <option value="">중분류 선택하세요.</option>
			    </select>
			
		</div>
		</td>
     </tr>
     <tr>
	                <th id="upload_th">사진 첨부 </th>
	                <td>
	                <input id="upload_file" type="file" name="file" id="photoImg"/>
                	</td>
                	<%=request.getRealPath("/") %>
      </tr>
      <!-- 
     		<tr>
                <th id="upload_th">영상 링크 </th>
                <td><input type="text" placeholder="영상 링크를 입력하세요" name="video_url" class="form-control"/></td>
            </tr>
		-->
            <tr>
                <td colspan="2">
                    <input id="upload_btn" type="submit" value="등록" class="pull-right"/>
                    <input id="upload_btn" type="reset" class="pull-left"/>
                    <input id="upload_btn" type="button" value="뒤로가기" class="pull-right" onclick="javascript:location.href='about'"/>         
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>
    </tbody>
</table>
</form>  
</div>
</body>
</html>