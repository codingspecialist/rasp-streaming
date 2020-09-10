<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		
		<div class="d-flex justify-content-center" >
		
			<div class="card align-self-center" style="width: 40rem; border-radius: 20px;">
			
				<div class="card-body">
					<form action="/manager/funeral" method="POST">
						<input name="customerName"  type="text" class="form-control" placeholder="고객명" required autofocus>
						<br/>
						<input name="customerPhone" type="text" class="form-control" placeholder="고객전화번호" required autofocus>
						<br/>
						<input id="startDate" type="date" name="startDate"  class="form-control" />
						<br/>
											
						<!-- 해당 매니저 장례식장에서 위에 선택된 날짜에 사용되지 않는 모든 호실 가져오기 -->
						<!-- 배치 프로그램 돌려서 고객이 호실을 현재 사용중인지 아닌지 체크 하는 필드 필요 -->
						<select id="activeRoom" name="roomId" class="form-control">
								<option>호실선택</option>
						</select>
						<br/>
						
						<button class="btn btn-lg btn-primary btn-block" type="submit">장례식등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<script src="/js/funeral.js"></script>
<%@ include file="../../layout/footer.jsp"%>
