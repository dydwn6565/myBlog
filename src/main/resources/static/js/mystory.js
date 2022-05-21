/**
 * 
 */
 
 let index ={
	init:function(){
		$("#write-my-story").on("click",()=>{
			this.writeMyStory();
		})
	},
	
	writeMyStory:function(){
		
		$.ajax({
			type:"POST",
			url:"/api/mystory/write",
			
		})
	}
}