<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>호실</th>
					<th>회사명</th>
					<th>사용여부</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="room" items="${rooms.content}">
					<tr>
						<td>${room.id}</td>
						<td>${room.roomNum }</td>
						<td>${room.company.name}</td>
						<td>
						<c:forEach var="funeral" items="${room.funerals}">
							<c:if test="${funeral.useState == true}">
								사용중
							</c:if>
						</c:forEach>
						</td>
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
