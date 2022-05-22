 
 let index ={
	init:function(){
		
		$("#mystory-create").on("click",()=>{
			this.writeMyStory();
		});
		$("#mystory-modify").on("click",()=>{
			this.modifyMyStory();
		});
		$("#mystory-delete").on("click",()=>{
			this.deleteMyStory();
		})
		
	},
	
	writeMyStory:function(){
		
		let data={
			title:$("#mystory-title").val(),
			content:$("#mystory-content").val()
		};
		
		$.ajax({
			type:"POST",
			url:"/api/mystory/write",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
//			dataType:"json"
		}).done(function(resp){
			
			alert("Your new story is added");
			location.href="/mystory"
		}).fail(function(err){
			
			alert(JSON.stringify(err))
		})
	},
	
	modifyMyStory:function(){
		let id=$("#modified-id").text();
		
		let data={
			title:$("#mystory-modified-title").val(),
			content:$("#mystory-modified-content").val(),
			
		};
		
		$.ajax({
			type:"PUT",
			url:"/api/mystory/modify/"+id,
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("successfully modified ")
			location.href="/mystory"
		}).fail(function(err){
			alert(JSON.stringify(err))
		})
	},
	
	deleteMyStory:function(){
		let id=$("#mystory-delete-number").text();
		
		$.ajax({
			type:"DELETE",
			url:"/api/mystory/delete/"+id,
//			dataType:"json"
		}).done(function(resp){
			alert("Successfully my story deleted");
			location.href="/mystory"
		}).fail(function(err){
			alert(JSON.stringify(err));
		})
	}
}

index.init();