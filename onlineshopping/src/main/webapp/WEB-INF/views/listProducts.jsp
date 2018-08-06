<div class="container">
	<div class="row">

		<!-- 	Would be to display sidebar -->

		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>
		</div>


		<div class="col-md-9">
			<!-- Added breadcrum component  -->
			<div class="row">

				<div class="col-lg-12">

					<nav aria-label="breadcrumb">
						<c:if test="${userClickAllProducts == true }">
							<ol class="breadcrumb">

								<li class="breadcrumb-item "><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">All Products</li>

							</ol>

						</c:if>

						<c:if test="${userClickCategoryProducts == true }">
							<ol class="breadcrumb">

								<li class="breadcrumb-item active"><a href="${contextRoot }/home">Home</a></li>
								<li class="breadcrumb-item active">Category</li>
								<li class="breadcrumb-item active">${category.name }</li>


							</ol>

						</c:if>

					</nav>

				</div>
			</div>

		</div>

	</div>

</div>