<%@ include file="../layout/header.jsp"%>

<div class="card-header">My Photo</div>

<div class="row">

	<c:forEach var="myPhoto" items="${myphoto.content}">

		<div class="col-4">
			<div class="card" style="width: 18rem;">
				
				<%--   <img src="data:image/jpg;base64,${myphoto.content[0].photo}"  class="card-img-top" alt="..." id="myphoto-images"> --%>
				<div class="card-body">

					<img src="data:image/jpg;base64,${myPhoto.photo}"
						class="card-img-top" alt="..." id="myphoto-images">

					<p class="card-text">${myPhoto.content}</p>
					<a href="/myphoto/${myPhoto.id}" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>
	</c:forEach>
	<ul class="pagination justify-content-center">
	<c:choose>
		<c:when test="${myphoto.first }">
			<li class="page-item disabled"><a class="page-link" href="?page=${myphoto.number-1}">Previous</a></li>
			
			
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${myphoto.number-1}">Previous</a></li>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
	<c:when test="${myphoto.last }">
	<li class="page-item disabled"><a class="page-link" href="?page=${myphoto.number+1 }">Next</a></li>
	
	</c:when>
	<c:otherwise>
	<li class="page-item"><a class="page-link" href="?page=${myphoto.number+1}">Next</a></li>
	
	</c:otherwise>
	</c:choose>
	</ul>
	
	<a href="/myphoto/write" class="btn btn-primary">write</a>
	</body>
	
	<script src="/js/myphoto.js"></script>


	</html>