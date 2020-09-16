<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>고객명</th>
					<th>고객전화번호</th>
					<th>사용호실</th>
					<th>장례시작일</th>
					<th>장례종료일</th>
					<th>사용여부</th>
					<th>예약접수날짜</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="funeral" items="${funerals.content}">
					<tr>
						<td>${funeral.id}</td>
						<td>${funeral.customerName}</td>
						<td>${funeral.customerPhone}</td>
						<td>${funeral.room.roomNum}</td>
						<td>${funeral.startDate}</td>
						<td>${funeral.endDate}</td>
						<td>${funeral.useState}</td>
						<td>${funeral.createDate}</td>
						<td><button onclick="delete(${room.id})" class="btn btn-danger">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${rooms.first}">
					<li class="page-item disabled"><a class="page-link" href="?page=${rooms.number-1}">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${rooms.number-1}">Previous</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${rooms.last}">
					<li class="page-item disabled"><a class="page-link" href="?page=${rooms.number+1}">Next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${rooms.number+1}">Next</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
</main>
<%@ include file="../../layout/footer.jsp"%>
