
<%@ include file="../layout/header.jsp"%>
<div>
<!-- 	<div class="mb-3"> -->
<!-- 		<label for="mystory-input" -->
<!-- 			class="form-label d-flex justify-content-center mt-2">Mystory -->
<!-- 			title</label> <input type="text" class="form-control  w-75 " -->
<!-- 			style="margin: 0 auto; float: none;" id="myphoto-title"> -->
<!-- 	</div> -->
	<div class="container d-flex justify-content-center">
	
	<img src="" height="400" id="myphoto"  >
	</div>
	<div class="mb-3">

		<textarea class="form-control w-75 "
			style="margin: 0 auto; float: none; height: 25vh;"
			id="myphoto-content" rows="3"></textarea>


		<button type="button" id="myphoto-create"
			class="btn btn-success float-end mt-2" style="margin-right: 12%">Create</button>
	</div>


	<div class="container">

		Select Image <input type="file"
			accept="image/png ,image/jpg, image/jpeg, image/gif"
			onchange="return fileValidation()" id="file" name="photo">
	</div>


</div>
</body>
<script src="/js/myphoto.js"></script>
</html>