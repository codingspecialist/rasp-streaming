let index = {
	init: function(){
		$("#startDate").on('change', (e)=> {
			this.activeRooms(e);
		})
	},

	activeRooms: function (e) {
		console.log(e.target.value);
		let startDate = e.target.value;

		fetch("/api/v1/activeRooms?startDate=" + startDate).then(function (res) {
			return res.json();
		}).then(function (res) {
			console.log(1, res);			
			roomAppend(res);
		});
	}
}

index.init();

function roomAppend(activeRooms){
	$("#activeRoom").empty();
	activeRooms.forEach(room => {
		$("#activeRoom").append(`<option value='${room.id}'>${room.roomNum}</option>`);
	});
}



