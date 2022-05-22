<%@ include file="../layout/header.jsp" %>
	<div class="mb-3">
  <label for="mystory-input" class="form-label d-flex justify-content-center mt-2">Mystory title</label>
  <input type="text" class="form-control  w-75 " style="margin: 0 auto; float: none;"  id="mystory-title">
</div>
<div class="mb-3">
  <label for="mystory-content" class="form-label d-flex justify-content-center" >Mystory content</label>
  <textarea class="form-control w-75 " style="margin: 0 auto; float: none; height:55vh; " id="mystory-content" rows="3"></textarea>
  
  
 <button type="button" id="mystory-create" class="btn btn-success float-end mt-2" style="margin-right:12%" >Create</button>
</div>

</body>
<script src="/js/mystory.js"></script>
</html>