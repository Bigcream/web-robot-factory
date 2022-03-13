<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/Admin/new/list" />
<c:url var="editNewURL" value="/Admin/new/edit" />
<c:url var="newAPI" value="/api/new" />
<!DOCTYPE html>
<html>
<head>
<title>Edit News</title>
</head>
<body>
	<form:form action="" class="tm-edit-product-form" id="formSubmit"
		role="form" commandName="model">
		<div id="layoutSidenav_content">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<div class="row">
				<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="row">
							<div class="col-12">
								<h2 class="tm-block-title d-inline-block">Add News</h2>
							</div>
						</div>
						<div class="row tm-edit-product-row">

							<div class="col-xl-6 col-lg-6 col-md-12">

								<div class="form-group mb-3">
									<label for="title">Title </label>
									<form:input path="title" id="title"
										class="form-control validate" />
								</div>

								<div class="form-group mb-3">
									<label for="categoryCode">Category</label>
									<form:select class="custom-select tm-select-accounts"
										path="categoryCode" id="categoryCode">
										<form:option value="" label="-- Select category --" />
										<form:options items="${categories}" />
									</form:select>
								</div>
								<div class="form-group mb-3">
									<label for="shortDescription">Short description</label>
									<form:textarea path="shortDescription" id="shortDescription"
										class="form-control validate" rows="3" />

								</div>

							</div>

							<div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">

								<div class="tm-product-img-dummy mx-auto">
									<i onclick="document.getElementById('fileInput').click();"></i>
									<img id="imageBase64" src="${model.thumbnail}" style="height: 240px; width: 340px" />
								</div>
								<div class="custom-file mt-3 mb-3">
								<form:input path="thumbnail" type="file" class="form-control" id="inputFileToLoad" onchange="encodeImageFileAsURL();"/>
								</div>
							</div>
							<div class="form-group mb-6">
								<label for="content">Content</label>
								<form:textarea path="content" id="content" rows="5" cols="10"
									class="form-control validate" />
							</div>
							<input type="hidden" value="${model.thumbnail}" id="thumbnail" name="thumbnail"/>
							<form:hidden path="id" id="newId" />
							<div class="col-12">
								<c:if test="${not empty model.id}">
									<button type="button" id="btnAddOrUpdateNew"
										class="btn btn-primary btn-block text-uppercase">Update
										News Now</button>
								</c:if>
								<c:if test="${empty model.id}">
									<button type="button" id="btnAddOrUpdateNew"
										class="btn btn-primary btn-block text-uppercase">Add
										News Now</button>
								</c:if>

								<a href="<c:url value='/Admin/new/list'/>"
									class="btn btn-primary btn-block text-uppercase">Back</a>
							</div>

						</div>
					</div>
				</div>
			</div>
			</main>
		</div>
	</form:form>
	    <script type='text/javascript'>
	    var base64 = null;

        </script>
	<script>
	
    function encodeImageFileAsURL() {

        var filesSelected = document.getElementById("inputFileToLoad").files;
        if (filesSelected.length > 0) {
            var fileToLoad = filesSelected[0];

            var fileReader = new FileReader();

            fileReader.onload = function (fileLoadedEvent) {
                var srcData = fileLoadedEvent.target.result; // <--- data: base64
                base64 = fileLoadedEvent.target.result;
                var newImage = document.createElement('img');
                newImage.src = srcData;
                document.getElementById("imageBase64").src = srcData;
                document.getElementById("imageBase64").innerHTML = imageBase64.outerHTML;
                console.log("Converted Base64 version is " + document.getElementById("imgTest").innerHTML);
            }
            fileReader.readAsDataURL(fileToLoad);
        }
    };
    
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};

			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			if(base64 != null){
				data["thumbnail"] = base64;
			}
			if(base64 == null){
				data["thumbnail"] = $('#thumbnail').val();
			}
			var id = $('#newId').val();
			
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		});

		function addNew(data) {
			$.ajax({
				url : '${newAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editNewURL}?message=insert_success";
				},
				error : function(error) {
					window.location.href = "${editNewURL}?message=error_system";
				}
			});
		}

		function updateNew(data) {
			$.ajax({
				url : '${newAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editNewURL}?id=" + result.id
							+ "&message=update_success";
				},
				error : function(error) {
					window.location.href = "${editNewURL}?id=" + result.id
							+ "&message=error_system";
				}
			});
		}
	</script>
</body>
</html>
