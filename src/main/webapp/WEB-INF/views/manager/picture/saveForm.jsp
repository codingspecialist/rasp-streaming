<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<style type="text/css">
input[type=file] {
	display: none;
}

.my_button {
	display: block;
	text-align: center;
	padding: 10px;
	background-color: #006BCC;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
}

.imgs_wrap {
	border: 2px solid #A8A8A8;
	margin-top: 30px;
	margin-bottom: 30px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.imgs_wrap img {
	max-width: 150px;
	margin-left: 10px;
	margin-right: 10px;
}
</style>

<div class="container">

	<div>
	    <!-- Save될 때 호실번호로 Funeral(장례식) useState가 활성환된 오브젝트를 찾고 
	    그 Funeral 오브젝트를 이용해서 Flower 오브젝트 생성 
	    그 Flower 오브젝트를 이용해서 Picture 객체 생성 후 Save하기-->
		<select class="form-control">
			<option>호실선택</option>
		</select>
		<input type="text" name="customerName" class="form-control" placeholder="화환고객명"/>
		<input type="text" name="customerPhone" class="form-control" placeholder="화환고객전화번호"/><br/>
		<div class="input_wrap">
			<a href="javascript:" onclick="fileUploadAction();" class="my_button">사진 선택</a> 
			<input type="file" id="input_imgs" multiple />
		</div>
	</div>

	<div>
		<div class="imgs_wrap">
			<img id="img" />
		</div>
	</div>

	<a href="javascript:" class="my_button" onclick="submitAction()">사진 업로드</a>
</div>


<script src="/js/picture.js"></script>

<%@ include file="../../layout/footer.jsp"%>