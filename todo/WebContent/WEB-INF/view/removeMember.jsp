<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  padding: 15px 25px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #EB7588;
  border: none;
  border-radius: 25px;
  box-shadow: 0 9px #ddd;
  width: 150px;
  margin: 15px;
}

.button:hover {background-color: #E75575}

.button:active {
  background-color: #DE4563;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

body {
  font-family:  'Ubuntu', sans-serif;
  padding: 20px;
  background: #f1f1f1;
}

/* Header/Blog Title */
.login {
  padding: 20%;
  /*font-size: 40px;*/
  text-align: center;
  background: white;
}
</style>
</head>
<body>
<div class="container text-center">
	<div class="login">
		<h1>deleteMember</h1>
		<form method="post" action="${pageContext.request.contextPath}/member/removeMember">
			<div class="form-group">
				<input type="hidden" name="memberId" value="${loginMember.getMemberId()}">
				<input class="form-control text-center" type="text" name="memberPw" placeholder="check pw" id="memberPw" value="">
			</div>
			<div>
				<button class="button btn btn-outline-danger" type="submit">exit</button>
				<a class="button btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar">calendar</a>
			</div>
		</form>
	</div>
</div>
</body>
</html>

