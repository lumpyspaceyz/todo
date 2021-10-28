<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- if문, for문을 만들어줌 -> c: 사용가능 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap');
</style>
<style>
.button {
  padding: 25px 30px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #EB7588;
  border: none;
  border-radius: 30px;
  box-shadow: 0 9px #ddd;
  width: 180px;
}

.button:hover {background-color: #E75575}

.button:active {
  background-color: #DE4563;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

.pink:hover {
  border-color: #EB7588 !important;
  background-color: #EB7588 !important;
}

body {
  font-family:  'Ubuntu', sans-serif;
  padding: 20px;
  background: #f1f1f1;
}

/* Header/Blog Title */
.header {
  padding: 30px 50px 40px 30px;
  font-size: 40px;
  text-align: center;
  background: white;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
  float: left;
  width: 80%;
}

/* Right column */
.rightcolumn {
  float: left;
  width: 20%;
  padding-left: 20px;
}

/* Fake image */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Add a card effect for articles */
.card {
  background-color: white;
  padding: 20px;
  margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
  margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
  .leftcolumn, .rightcolumn {
    width: 100%;
    padding: 0;
  }
}
</style>
</head>
<body>
<div class="container">
<%--
<div class="media border p-3">
  <img src="img_avatar3.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
  <div class="media-body">
    <h4>John Doe <small><i>Posted on February 19, 2016</i></small></h4>
    <p>Lorem ipsum...</p>
  </div>
</div>

	<div>
		${loginMember.memberId}님 반갑습니다
		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		<a href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
	</div>
	
	<!-- 달력 + todo -->
	<div>
		<h1>
			<span>
		         <a class="button btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">&laquo; Previous</a>
		      </span>
				${targetYear }년 ${targetMonth }월
			<span>
		         <a class="button btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">Next &raquo;</a>
		    </span>
		</h1>
		
		<div>
			이달의 total todo : ${todoList.size()}
		</div>
		<div class="table-responsive">
			<table class="table table-bordered" border="1" width="80%">
				<tr>
					<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
				</tr>
				<tr>
					<!-- JSTL for문 -->
					<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1">
						<c:if test="${i-startBlank >= 1 && i-startBlank<=endDay}">
							<td>
								<a href="${pageContext.request.contextPath }/member/todoList?y=${targetYear }&m=${targetMonth }&d=${i-startBlank }">${i-startBlank}</a>
								<div>
									<!-- 날짜별 일정 -->
									<c:forEach var="todo" items="${todoList }">
										<c:if test="${i-startBlank == todo.todoDate.substring(8)}">
											<div>${todo.todoContent }</div>
										</c:if>
									</c:forEach>
								</div>
							</td>
						</c:if>
						<c:if test="${i-startBlank < 1 || i-startBlank>endDay}">
							<td>&nbsp;</td>
						</c:if>
						
						<c:if test="${i%7 == 0}">
							</tr><tr>
						</c:if>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
--%>
	<div class="header">
	  	<span class="float-left">
	         <a class="button btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">&laquo; Previous</a>
	    </span>
	    <span class="display-4">
			${targetYear }년 ${targetMonth }월
		</span>
		<span class="float-right">
	         <a class="button btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">Next &raquo;</a>
	    </span>
	</div>
	
	<div class="row">
	  <div class="leftcolumn">
	    <div class="card" style="height: 100%;">
	     <div class="table-responsive">
			<table class="table table-bordered" border="1" width="80%">
				<tr class="text-center font-weight-bold">
					<th style="color: red;">SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th style="color: blue;">SAT</th>
				</tr>
				<tr>
					<!-- JSTL for문 -->
					<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1">
						<c:if test="${i-startBlank >= 1 && i-startBlank<=endDay}">
							<td width="14%" style="height: 150px;">
								<a href="${pageContext.request.contextPath }/member/todoList?y=${targetYear }&m=${targetMonth }&d=${i-startBlank }">${i-startBlank}</a>
								<div>
									<!-- 날짜별 일정 -->
									<c:forEach var="todo" items="${todoList }">
										<c:if test="${i-startBlank == todo.todoDate.substring(8)}">
											<div>${todo.todoContent }</div>
										</c:if>
									</c:forEach>
								</div>
							</td>
						</c:if>
						<c:if test="${i-startBlank < 1 || i-startBlank>endDay}">
							<td>&nbsp;</td>
						</c:if>
						
						<c:if test="${i%7 == 0}">
							</tr><tr>
						</c:if>
					</c:forEach>
				</tr>
			</table>
		</div>
	   </div>
	  </div>
	  <div class="rightcolumn">
	    <div class="card">
	      <h2 class="font-weight-bold"><span class="font-weight-light small">About </span> ${loginMember.memberId }</h2>
	      <div class="fakeimg" style="height:100px;">Image</div>
	      <p style="padding: 30px 12px 0 10px;">
	         <a href="${pageContext.request.contextPath}/member/logout" class="btn btn-outline-dark btn-sm float-left pink">logout</a>
	     	 <a href="${pageContext.request.contextPath}/member/removeMember" class="btn btn-outline-dark btn-sm float-right pink">&nbsp;&nbsp;exit&nbsp;&nbsp;</a>
	     </p>
	    </div>
	    <div class="card">
	      <h3 class="font-weight-bold">today todo</h3>
	      <div class="fakeimg">one</div><br>
	      <div class="fakeimg">two</div><br>
	      <div class="fakeimg">three</div>
	    </div>
	    <div class="card">
	      <h3 class="font-weight-bold">total todo</h3>
	      <p>${todoList.size()}</p>
	    </div>
	  </div>
	</div>
	
</div>
</body>
</html> 