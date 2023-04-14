<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC기반의방명록</title>
<style>
@font-face {
    font-family: 'Happiness-Sans-Title';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/Happiness-Sans-Title.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
* {
	font-family: 'Happiness-Sans-Title';
	text-align : center;
}
table {
	border-collapse: collapse;
	margin : 5px auto;
}

th {
	border-bottom: 2px solid #008000;
	padding: 5px 20px 5px 20px
}

td {
	border-bottom: 1px dotted #004d00;
	padding: 5px 20px 5px 10px;
	text-align : left;
}

th {
	color: #004d00;	
}

tr:hover {
	background-color: #b3ffb3;
}

hr {
	margin-bottom : 20px;
}

.buttonstyle {
	text-decoration : none;
	padding : 10px;
	border : none;
	border-radius : 5px;
	font-weight : bold;
	background-image : linear-gradient(to right, yellow,white,white,#66ff66);
}
#maintitle {
	font-size : 3em;
	color : #008000;
	text-shadow : 2px 2px 5px yellow;	
}
textarea, input {
	text-align : left;
	padding : 5px;
} 
</style>
</head>
<body>
<header>
  <h1 id="maintitle">방명록</h1>
  <nav>	  
	<button class="buttonstyle" onclick="displayTag('insert')">방명록 작성하기</button>
	<button class="buttonstyle" onclick="displayTag('search')">방명록 검색하기</button>
  </nav>
</header>
<aside>
	<h3>${ msg }</h3>
</aside>
<section>
  <article id="list">
    <c:choose>
	  <c:when test="${!empty list}">	  
	    <hr>	  
        <table>
          <tr><th>작성자명</th><th>작성글</th><th>작성날짜</th><th></th><th></th></tr>
		  <c:forEach var="item"  items="${list}">
		    <tr>
			<td>${ item.name }</td>
			<td>${ item.memo }</td>
			<td>${ item.writeDate }</td>
			<td><a href="/mvc/visitornew?action=delete&id=${item.id}"><img src="/mvc/images/delete.png" width="20"></a></td>
			<td><img src="/mvc/images/edit.png" width="20" onclick="updateForm(${item.id})"></td>
		    </tr>   		
	      </c:forEach>
	    </table>
	  </c:when>
	  <c:otherwise>
		<h2>${ listmsg }</h2>
	  </c:otherwise>
    </c:choose>
  </article> 
  <article id="insert" class="toggle" style="display:none">
    <h2>글을 작성하세요</h2>
    <hr>
	<form method="post" action="/mvc/visitornew">    
	  <input type="hidden" name="action" value="insert">    
        이름 : <input type="text" name="name" size="15"><br>
	    남기고자 하는 의견 : <br>
		<textarea  name= "memo" rows="10" cols="50"></textarea><br>
		<input type="submit" value="저장">
		<input type="reset"  value="재작성">
		<input type="button" value="취소" onclick="document.querySelector('#insert').style.display='none';">
	</form>
  </article>
  <article id="search" class="toggle" style="display:none">
  	<h3>검색하고자 하려는 단어를 입력하세요</h3>
  	<hr>
  	<form method="get" action="/mvc/visitornew"> 
      <input type="hidden" name="action" value="search">    
	  검색어 : <input type="search" name="keyword" size="15">
	  <input type="submit" value="검색">
  	</form>
  </article>
  <article id="update" class="toggle" style="display:none">
    <h2>글을 수정하세요</h2>
    <hr>
	<form method="post" action="/mvc/visitornew">    
	  <input type="hidden" name="action" value="update"> 
	  <input type="hidden" name="id" value="" id="id">       
      이름 : <input type="text" name="name" size="15" id="name"><br>
	  남기고자 하는 의견 : <br>
	  <textarea  name= "memo" rows="10" cols="50" id="memo"></textarea><br>
	  <input type="submit" value="수정">
	  <input type="reset"  value="재작성">
	  <input type="button" value="취소" onclick="document.querySelector('#update').style.display='none';">
	</form>
  </article>
</section>
<script>
	function displayTag(target) {
		document.querySelectorAll("section > .toggle").forEach(function(elem) {elem.style.display = "none"});
		let dom = document.querySelector("#"+target);
		dom.style.display = "block";
	}
	function updateForm(id) {
		var xhr = new XMLHttpRequest();
		xhr.onload = function () {
			if(xhr.status == 200) {				
				let jsondom = JSON.parse(xhr.responseText);
				displayTag('update');
				document.querySelector("#name").value = jsondom.name;	
				document.querySelector("#memo").value = jsondom.memo;
				document.querySelector("#id").value = jsondom.id;
			}
		}
		xhr.open("GET", "/mvc/visitornew?action=one&id="+id, true);
		xhr.send();		
	}
</script>  
</body>
</html>







