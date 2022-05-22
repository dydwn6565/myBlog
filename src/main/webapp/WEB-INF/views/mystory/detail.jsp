<%@ include file="../layout/header.jsp" %>
	
	<div class=" mt-3 container d-flex justify-content-center p-3" style="background-color: #eee;">${mystory.title} 
	
	</div>
	<div class="border border-1 border-top-0 container " style="height: 55vh;">${mystory.content}

	</div>
	<div class="container p-1 my-1">
	<div id="mystory-delete-number" class="d-none" >${mystory.id}</div>
	<a class="btn btn-success float-end"  href="/mystory/${mystory.id}/modify">Modify</a>
	<div class="btn btn-danger float-end" id="mystory-delete">Delete</div>
	</div>
	
</body>
<script src="/js/mystory.js"></script>
</html>