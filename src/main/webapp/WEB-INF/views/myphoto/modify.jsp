<%@ include file="../layout/header.jsp"%>

<div class=" mt-3 container  ">

	
<%-- 	<p id="myphoto-file-number" >${myphotoFileName}1123</p> --%>
	<p id="myphoto-file-number" class="d-none">${myphotoFileName}</p>
	<img src="data:image/jpg;base64,${myphoto.photo}" alt="..."
		class=" border border-1 "
		style="display: block; margin-left: auto; margin-right: auto; width: 50%;" id="myphoto">

	<textarea class="form-control w-50 border border-top-0"
		style="margin: 0 auto; float: none; height: 15vh;"
		id="myphoto-modify-content" rows="3">${myphoto.content}</textarea>

</div>

<div class="container d-flex justify-content-center mt-3 me-5 ">

	Select Image <input style="width:20%;" type="file"
		accept="image/png ,image/jpg, image/jpeg, image/gif"
		onchange="return fileValidation()" id="file" name="photo" value="${myphotoFileName}">
</div>


<div class="container p-1 my-1"
	style="display: block; margin-left: auto; margin-right: auto; width: 35%;">
	<div id="myphoto-delete-number" class="d-none">${myphoto.id}</div>
	<button type="button" class="btn btn-success float-end"
		id="myphoto-modify">Modify</button>

</div>
<script src="/js/myphoto.js" ></script>
</body>

</html>