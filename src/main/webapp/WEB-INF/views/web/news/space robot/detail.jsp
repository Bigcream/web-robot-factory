<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
    <c:url var="detailURL" value="/Detail" />
<c:url var="cartAPI" value="/api/cart" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News detail</title>
</head>
<body>
<form action="<c:url value='/Admin-Product'/>" id="formSubmit" method="get">
        <div class="container mt-5">
            <div class="row">
                <div style="width: 1100px;" class="col-lg-8">
                    <!-- Post content-->
                    <article>
                        <!-- Post header-->
                        <header class="mb-4">
                            <!-- Post title-->
                            <h1 class="fw-bolder mb-1">Welcome to Blog Post!</h1>
                            <!-- Post meta content-->
                            <div style="color: #ffffff !important;" class="text-muted fst-italic mb-2">Posted on ${model.createdDate},  By ${model.createdBy}</div>
                            <!-- Post categories-->
                        </header>
                        <!-- Preview image figure-->
                        <figure class="mb-4"><img class="img-fluid rounded" style="    height: 300px;width: 400px;" src="${model.thumbnail}" alt="..." /></figure>
                        <!-- Post content-->
                        <section class="mb-5">
                            <p style="letter-spacing: 0px;" class="fs-5 mb-4">${model.content}</p>
                            <p style="letter-spacing: 0px;" class="fs-5 mb-4">The universe is large and old, and the ingredients for life as we know it are everywhere, so there's no reason to think that Earth would be unique in that regard. Whether of not the life became intelligent is a different question, and we'll see if we find that.</p>
                            <p style="letter-spacing: 0px;" class="fs-5 mb-4">If you get asteroids about a kilometer in size, those are large enough and carry enough energy into our system to disrupt transportation, communication, the food chains, and that can be a really bad day on Earth.</p>
                            <h2 style="letter-spacing: 0px;" class="fw-bolder mb-4 mt-5">I have odd cosmic thoughts every day</h2>
                            <p style="letter-spacing: 0px;" class="fs-5 mb-4">For me, the most fascinating interface is Twitter. I have odd cosmic thoughts every day and I realized I could hold them to myself or share them with people who might be interested.</p>
                            <p style="letter-spacing: 0px;" class="fs-5 mb-4">Venus has a runaway greenhouse effect. I kind of want to know what happened there because we're twirling knobs here on Earth without knowing the consequences of it. Mars once had running water. It's bone dry today. Something bad happened there as well.</p>
                        </section>
                    </article>
                    <!-- Comments section-->
                    <section class="mb-5">
                        <div class="card bg-light">
                            <div class="card-body">
                                <!-- Comment form-->
                                <form class="mb-4"><textarea class="form-control" rows="3" placeholder="Join the discussion and leave a comment!"></textarea></form>
                                <!-- Comment with nested comments-->
                                <div class="d-flex mb-4">
                                    <!-- Parent comment-->
                                    <div class="flex-shrink-0"><img class="rounded-circle" style="height: 50px;width: 50px;" src="<c:url value='/template/web/assets/images/1575377212_timthumb.png'/>" alt="..." /></div>
                                    <div class="ms-3" style="letter-spacing: 0px;color: black;">
                                        <div class="fw-bold">Commenter Name</div>
                                        If you're going to lead a space frontier, it has to be government; it'll never be private enterprise. Because the space frontier is dangerous, and it's expensive, and it has unquantified risks.
                                        <!-- Child comment 1-->
                                        <div class="d-flex mt-4">
                                            <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                            <div class="ms-3">
                                                <div class="fw-bold">Commenter Name</div>
                                                And under those conditions, you cannot establish a capital-market evaluation of that enterprise. You can't get investors.
                                            </div>
                                        </div>
                                        <!-- Child comment 2-->
                                        <div class="d-flex mt-4">
                                            <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                            <div class="ms-3">
                                                <div class="fw-bold">Commenter Name</div>
                                                When you put money directly to a problem, it makes a good headline.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Single comment-->
                                <div class="d-flex">
                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">Commenter Name</div>
                                        When I look at the universe and all the ways the universe wants to kill us, I find it hard to reconcile that with statements of beneficence.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>

            </div>
        </div>
         <div class="row">
                        <div class="col-md-12">
                            <a style="color: white;" href="#" class="btn btn-expand-all">Back top</a>
                        </div>
                    </div>
<input type="hidden" value="${model.id}" id="id" name="id"/>
</form>
<script>
		
        $("#btnAddToCart").click(function () {
            var data = {};
            var id = $('#id').val();
            data["id"] = id;
            addCart(data);

        });
        
		function addCart(data) {
			$.ajax({
				url : '${cartAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),

				success : function(result) {
					window.location.href = "${detailURL}";
				},
				error : function(error) {
					window.location.href = "${detailURL}"+ "?id=" + ${model.id} + "&message=error";
				}
			});
		}
</script>
</body>
</html>