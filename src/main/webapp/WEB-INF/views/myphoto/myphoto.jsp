<%@ include file="../layout/header.jsp" %>
<%--   <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
	<div class="card-header">
    My Photo
  </div>
  
  <div class="row">
<%--   <h1>${myphoto.content.getId(0}</h1> --%>
  
  
  <c:forEach var="myPhoto" items="${myphoto.content}">
  
   <div class="col-4">
	<div class="card" style="width: 18rem;">
	<div id="image-userid">${myPhoto.userid}</div>
<%-- 	<div id="image-path">${myPhoto.photo}</div> 

<%-- <%--   <img src=`c:\\Users\\Lee//yong//Ju\\Desktop\\app\\resources\\"${myPhoto.photo}"`  class="card-img-top" alt="..." id="myphoto-images"> --%> 
<%--   <img src="data:image/jpg;base64,${myphoto.content[0].photo}"  class="card-img-top" alt="..." id="myphoto-images"> --%>
<!--   <div class="card-body"> -->

  <img src="data:image/jpg;base64,${myPhoto.photo}"  class="card-img-top" alt="..." id="myphoto-images">
       
    <p class="card-text">${myPhoto.content}</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
  </div>
  </div>
  </c:forEach>

<a href="/myphoto/write" class="btn btn-primary">write</a>
</body>

<script src="/js/myphoto.js"></script>


</html>