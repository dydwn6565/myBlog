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
		reader.readAsDataURL(file);
	}
}


 let index ={
	init:function(){
		$("#myphoto-create").on("click",()=>{
			
			this.writeMyphoto();
			
		});
	},
	
	writeMyphoto:function(){
		
		
		let data ={
			photo:$("#myphoto").attr('src'),
			content:$("#myphoto-content").val()
		}
		 
		 
		console.log("type"+jQuery.type(data.photo))
		$.ajax({
			type:"POST",
			url:"/api/myphoto/write",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
//			dataType:"json"
		}).done(function(resp){
			alert("successfully writed")
			location.href="/myphoto"
		}).fail(function(err){
			alert(JSON.stringify(err))
		})
	}
}
			
index.init();
		