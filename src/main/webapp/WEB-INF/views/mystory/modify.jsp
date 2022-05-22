<%@ include file="../layout/header.jsp" %>
	<div class="mb-3">
	
	<div class="d-flex justify-content-center mt-2">
	<div>Writing number: </div><div id="modified-id">${mystory.id}</div>
	</div>
	
  <label for="mystory-input" class="form-label d-flex justify-content-center mt-2">Mystory title</label>
	
  <input type="text" class="form-control  w-75 " style="margin: 0 auto; float: none;"  id="mystory-modified-title" value="${mystory.title} ">
  
</div>
<div class="mb-3">
  <label for="mystory-content" class="form-label d-flex justify-content-center" >Mystory content</label>
  <textarea class="form-control w-75 "  style="margin: 0 auto; float: none; height:55vh; " id="mystory-modified-content" rows="3" >${mystory.content}</textarea>
  <div class="container p-1 my-1">
  <button type="button" class="btn btn-success float-end" id="mystory-modify" >Modify</button>
  </div>
</div>
</body>
<script src="/js/mystory.js"></script>
</html>