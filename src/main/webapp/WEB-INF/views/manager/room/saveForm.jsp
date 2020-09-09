<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		
		<div class="d-flex justify-content-center" >
		
			<div class="card align-self-center" style="width: 40rem; border-radius: 20px;">
			
				<div class="card-body">
					<form action="/manager/room" method="POST">
						<input name="roomNum" type="text" class="form-control" placeholder="호실" required autofocus>
						<br/>
						<button class="btn btn-lg btn-primary btn-block" type="submit">호실등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="../../layout/footer.jsp"%>
