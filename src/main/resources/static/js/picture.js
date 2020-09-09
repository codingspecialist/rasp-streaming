// 이미지 정보들을 담을 배열
var sel_files = [];

$(document).ready(function () {
	$("#input_imgs").on("change", handleImgFileSelect);
});

function fileUploadAction() {
	console.log("fileUploadAction");
	$("#input_imgs").trigger('click');
}

function handleImgFileSelect(e) {

	// 이미지 정보들을 초기화
	sel_files = [];
	$(".imgs_wrap").empty();

	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);

	var index = 0;
	filesArr
		.forEach(function (f) {
			if (!f.type.match("image.*")) {
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			sel_files.push(f);

			var reader = new FileReader();
			reader.onload = function (e) {
				var html = "<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("
					+ index
					+ ")\" id=\"img_id_"
					+ index
					+ "\"><img src=\"" + e.target.result + "\" data-file='" + f.name + "' class='selProductFile' title='Click to remove'></a>";
				$(".imgs_wrap").append(html);
				index++;

			}
			reader.readAsDataURL(f);

		});
}

function deleteImageAction(index) {
	console.log("index : " + index);
	console.log("sel length : " + sel_files.length);

	sel_files.splice(index, 1);

	var img_id = "#img_id_" + index;
	$(img_id).remove();
}

function fileUploadAction() {
	console.log("fileUploadAction");
	$("#input_imgs").trigger('click');
}

function submitAction() {
	console.log("업로드 파일 갯수 : " + sel_files.length);
	var formData = new FormData();

	for (var i = 0, len = sel_files.length; i < len; i++) {
		//var name = "files" + i;
		formData.append("files", sel_files[i]);
	}
	formData.append("image_count", sel_files.length);


	if (sel_files.length < 1) {
		alert("한개이상의 파일을 선택해주세요.");
		return;
	}

	fetch("/manager/picture", {
		method: "post",
		body: formData
	}).then(function (res) {
		return res.text();
	}).then(function (res) {
		console.log("success", res);
		alert("사진 업로드 완료");
		location.reload();
	});

	console.log(formData);
}