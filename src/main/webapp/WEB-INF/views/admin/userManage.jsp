<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<main>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>유저네임</th>
					<th>업체명</th>
					<th>전화번호</th>
					<th>패스워드</th>
					<th>권한</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users.content}">
					<tr>
						<td>${user.id}</td>
						<td>${user.username }</td>
						<td>${user.companyName}</td>
						<td>${user.phone}</td>
						<td><button onclick="initPassword(${user.id})" class="btn btn-primary">초기화</button></td>
						<td>
							<div class="dropdown">
								<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">${user.role}</button>
								<div class="dropdown-menu">
									<button onclick="update(${user.id},'GUEST', ${users.number})" class="dropdown-item">GUEST</button>
									<button onclick="update(${user.id},'USER', ${users.number})" class="dropdown-item">USER</button>
									<button onclick="update(${user.id},'ADMIN', ${users.number})" class="dropdown-item">ADMIN</button>
								</div>
							</div>
						</td>
						<td><button onclick="delete(${user.id})" class="btn btn-danger">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${users.first}">
					<li class="page-item disabled"><a class="page-link" href="?page=${users.number-1}">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${users.number-1}">Previous</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${users.last}">
					<li class="page-item disabled"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
</main>
<%@ include file="../layout/footer.jsp"%>
