<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<main>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>회사명</th>
					<th>회사주소</th>
					<th>회사전화번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="company" items="${companys.content}">
					<tr>
						<td>${company.id}</td>
						<td>${company.name }</td>
						<td>${company.address}</td>
						<td>${company.phone}</td>
						<td><button onclick="delete(${company.id})" class="btn btn-danger">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${companys.first}">
					<li class="page-item disabled"><a class="page-link" href="?page=${companys.number-1}">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${companys.number-1}">Previous</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${companys.last}">
					<li class="page-item disabled"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
</main>
<%@ include file="../../layout/footer.jsp"%>
