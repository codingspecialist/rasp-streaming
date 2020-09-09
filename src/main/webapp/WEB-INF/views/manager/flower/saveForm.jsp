<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		
		<div class="d-flex justify-content-center" >
		
			<div class="card align-self-center" style="width: 40rem; border-radius: 20px;">
			
				<div class="card-body">
					<form action="/manager/customer" method="POST">
						<input name="name" type="text" class="form-control" placeholder="고객명" required autofocus>
						<br/>
						<input name="phone" type="text" class="form-control" placeholder="고객전화번호" required autofocus>
						<br/>
						<!-- 매니저가 등록하는 거니까 회사는 서버에서 찾을 수 있음 -->
						
						<!-- 해당 매니저 장례식장에서 사용되지 않는 모든 호실 가져오기 -->
						<!-- 배치 프로그램 돌려서 고객이 호실을 현재 사용중인지 아닌지 체크 하는 필드 필요 -->
						<select name="roomId">
							<c:forEach var="room" items="${rooms}">
								<option></option>
							</c:forEach>
						</select>
						<button class="btn btn-lg btn-primary btn-block" type="submit">화환고객등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="../../layout/footer.jsp"%>
