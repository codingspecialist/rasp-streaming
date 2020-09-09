<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<main>
	<div class="container">
		<div class="d-flex justify-content-center">
			<div class="card align-self-center" style="width: 40rem; border-radius: 20px;">
				<div class="card-body">
					<form action="/auth/login" method="POST">
						<input name="username" type="text" class="form-control" placeholder="Username" required
							autofocus>
						<br />
						<input name="password" type="password" class="form-control" placeholder="Password" required>
						<br />
						<button class="btn btn-lg btn-primary btn-block" type="submit">로 그 인</button>
						<br />
						<button type="button" class="btn btn-info m-1">아이디찾기</button>
						<button type="button" class="btn btn-info m-1">비밀번호찾기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="../layout/footer.jsp"%>