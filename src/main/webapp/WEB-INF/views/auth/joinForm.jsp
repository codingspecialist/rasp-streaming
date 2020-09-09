<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<main>
	<div class="container">
		
		<div class="d-flex justify-content-center">

			<div class="card align-self-center" style="width: 40rem; border-radius: 20px;">

				<div class="card-body">
					<form action="/auth/join" method="POST">
						<h6 class="form-signin-heading">회원가입 후 010-0000-0000로 연락주셔야 서비스 이용이 가능합니다.</h6>
						<input name="username" type="text" class="form-control" placeholder="Username" required
							autofocus>
						<br />
						<input id="join--password" name="password" type="password" class="form-control"
							placeholder="Password" required>
						<br />
						<input id="join--password-check" type="password" class="form-control"
							placeholder="Password Check" required>
						<br />
						<select name="companyId" class="form-control">
							<option value="0">회사선택안함</option>
							<c:forEach var="company" items="${companys}">
								<option value="${company.id}">${company.name}</option>
							</c:forEach>
						</select>
						<br />
						<input name="phone" type="text" class="form-control" placeholder="01088880000" required>
						<br />
						<button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>