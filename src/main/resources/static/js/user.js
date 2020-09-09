let index = {
	init : function() {
		$("#join--password-check").on("change", ()=> {
			this.passwordCheck();
		});
	},

	passwordCheck : function() {
		let password = $("#join--password").val();
		let passwordCheck = $("#join--password-check").val();

		if (password != passwordCheck) {
			alert("비밀번호가 동일하지 않습니다.");
			$("#join--password-check").val("");
			$("#join--password-check").focus();
		}
	}

}

index.init();
