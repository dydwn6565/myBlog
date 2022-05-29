function fileValidation() {
	var fileInput =
		document.getElementById('file');

	var filePath = fileInput.value;

	// Allowing file type
	var allowedExtensions =
		/(\.jpg|\.jpeg|\.png|\.gif)$/i;

	if (!allowedExtensions.exec(filePath)) {
		alert('Invalid file type');
		fileInput.value = '';
		return false;
	} else {
		previewFile();
	}
}


function previewFile() {
	const preview = document.querySelector('img');
	const file = document.querySelector('input[type=file]').files[0];
	const reader = new FileReader();

	reader.addEventListener("load", function() {
		// convert image file to base64 string
		preview.src = reader.result;
	}, false);

	if (file) {
		console.log(file.name);
		console.log(file);
		reader.readAsDataURL(file);
	}
}



let index = {
	init: function() {


		$("#myphoto-create").on("click", () => {

			this.writeMyphoto();

		});
		$("#myphoto-modify").on("click", () => {
			this.modifyMyphoto();
		})
	},

	writeMyphoto: function() {

		const image = document.getElementById("file").files[0];
		let data = {
			fileBase64: $("#myphoto").attr('src'),
			content: $("#myphoto-content").val(),
			fileName: image.name
		}
		console.log("fileBase" + data.fileBase64);

		$.ajax({
			type: "POST",
			url: "/api/myphoto/write",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			//			dataType:"json"
		}).done(function(resp) {
			alert("successfully writed")
			//			location.href = "/myphoto"
		}).fail(function(err) {
			alert(JSON.stringify(err))
		})
	},

	modifyMyphoto: function() {

		//		const image = document.getElementById("file").files[0];
		let imageName;
		
		 
		if(imageName ===null || imageName===undefined){
			
			let data={	
			id:$("#myphoto-file-number").text()
			}
			
			imageName =data.id;

			
		}else{
			
			imageName= document.getElementById("file").files[0].name;
		}
		
				let data={
					id:$("#myphoto-delete-number").text(),
					fileBase64: $("#myphoto").attr('src'),
					content: $("#myphoto-modify-content").val(),
					fileName: imageName
				}
				
				$.ajax({
					type:"PUT",
					url: "/api/myphoto/modify",
					data:JSON.stringify(data),
					contentType:"application/json; charset=utf-8",
				}).done(function(resp){
					alert("succssfully modified")
					history.back();
				}).fail(function(err){
					alert(JSON.stringify(err));
				})
	}
}

index.init();
