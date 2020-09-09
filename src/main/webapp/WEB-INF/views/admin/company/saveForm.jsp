<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		
		<div class="d-flex justify-content-center" >
		
			<div class="card align-self-center" style="width: 40rem; border-radius: 20px;">
			
				<div class="card-body">
					<form action="/admin/company" method="POST">
						<input name="name" type="text" class="form-control" placeholder="CompanyName" required autofocus>
						<br/>
						<div class="d-flex justify-content-end"><button class="btn btn-info">주소검색</button></div>
						<input name="address" type="text" class="form-control" placeholder="Address" required> <!-- 나중에 라이브러리 달기 readonly 변경 -->
						<br/>
						<input name="phone" type="text" class="form-control" placeholder="01088880000" required>
						<br/>
						<button class="btn btn-lg btn-primary btn-block" type="submit">회사등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="../../layout/footer.jsp"%>
