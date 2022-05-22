
<%@ include file="../layout/header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="card">
  <div class="card-header">
    My story
  </div>
<c:forEach var="MyStory" items="${mystory.content}">
  	<div class="card m-2">
  	<div class="card-body">
  	
  		<h4 class="card-title">${MyStory.title}</h4>
  		<p class="card-text">${MyStory.content}</p>
  		<a href="/mystory/${MyStory.id}" class="btn btn-primary">details</a>
  	</div>
  	 </div>
</c:forEach>
  <ul class="pagination justify-content-center">
  	<c:choose>
  		<c:when test="${mystory.first}">
  		<li class="page-item disabled"><a class="page-link" href="?page=${mystory.number-1}">Previous</a></li>
  		
  		</c:when>
  		<c:otherwise>
  			<li class="page-item"><a class="page-link" href="?page=${mystory.number-1}">Previous</a></li>
  		</c:otherwise>
  	</c:choose>
  	
  	<c:choose>
  	<c:when test="${mystory.last}">
  	<li class="page-item disabled"><a class="page-link" href="?page=${mystory.number+1}">Next</a></li>
  	
  	</c:when>
  	<c:otherwise>
  	<li class="page-item"><a class="page-link" href="?page=${mystory.number+1 }">Next</a></li>
  	</c:otherwise>
  	</c:choose>
  </ul>
  <a href="/mystory/write" class="btn btn-primary">write</a>
 
</div>
</body>
</html>