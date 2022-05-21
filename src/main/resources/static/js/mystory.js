 
 let index ={
	init:function(){
		$("#mystory-create").on("click",()=>{
			this.writeMyStory();
		})
	},
	
	writeMyStory:function(){
		
		let data={
			title:$("#mystory-title"),
			content:$("#mystory-content")
		}
		
		$.ajax({
			type:"POST",
			url:"/api/mystory/write",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("Your new story is added");
			location.href="/mystory"
		})
	}
}