<%@ include file="../layout/header.jsp"%>

<div class=" mt-3 container  ">
	
	
	<img src="data:image/jpg;base64,${myphoto.photo}" alt="..."
		class=" border border-1 "
		style="display: block; margin-left: auto; margin-right: auto; width: 50%;">
	<div class="d-flex  justify-content-center text-center border border-top-0 p-3 " style="display: block; margin-left: auto; margin-right: auto; width: 50%; height:15vh">${myphoto.content}</div>
	


</div>
<div class="container p-1 my-1"  style="display: block; margin-left: auto; margin-right: auto; width: 35%;">
	<div id="mystory-delete-number" class="d-none">${myphoto.id}</div>
	<a class="btn btn-success float-end"
		href="/myphoto/${myphoto.id}/modify">Modify</a>
	<div class="btn btn-danger float-end" id="mystory-delete">Delete</div>
</div>

</body>
</html>