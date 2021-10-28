<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
  padding: 10px 20px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #EB7588;
  border: none;
  border-radius: 25px;
  box-shadow: 0 9px #ddd;
  
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
<div class="container">
	<div class="row">
	  <div class="leftcolumn">
	    <div class="card" style="height: 100%; padding-top: 50px;">
			<div>
				<h1>modify todo</h1>
				<!-- AddTodoController.dopost() -->
				<form method="post" action="${pageContext.request.contextPath}/member/modifyTodo">
					<div class="form-group">
		                <input type="hidden" name="memberId" value="${loginMember.memberId}">
		                <input type="hidden" name="todoNo" value="${oneTodo.todoNo}">
		                <input class="form-control text-center" type="text" name="todoDate" value="${oneTodo.todoDate}" readOnly="readonly" class="form-control">
					</div>
					<div class="form-group">
						<textarea rows="3" cols="50" name="todoContent" class="form-control text-center">${oneTodo.todoContent}</textarea>
					</div>
					<button class="button btn btn-outline-danger btn-block" type="submit">modify todo</button>
				</form>
			</div>
			<div style="padding-top: 30px;">
				<a href="${pageContext.request.contextPath}/member/calendar" class="button btn btn-outline-danger btn-block">calendar</a>
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
	
	<a href="${pageContext.request.contextPath}/member/calendar">캘린더</a>
</div>
</body>
</html>