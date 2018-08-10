<div class="container">

	<!-- Breadcrum -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home </a></li>
				<li><a href="${contextRoot}/show/all/products">Products </a></li>
				<li class="active">${product.name}</li>


			</ol>

		</div>

	</div>

	<div class="row">

		<!-- 		Mostrar la imagen del producto -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>

		</div>

		<!-- 		Mostrar la imagen del producto -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name }</h3>
			<hr />

			<p>${product.description }</p>
			<hr />

			<h4>
				Price: <strong>S/. ${product.unitPrice }/-</strong>
			</h4>
			<hr />




			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Sin stock!</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>

			</c:choose>

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<a href="javascript.void(0)" class="btn btn-success disabled"><span
						class="glyphicon glyphicon-shopping-cart "
						style="text-decoration: line-through;"></span> Add to Cart</a>

				</c:when>
				<c:otherwise>

					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"><span
						class="glyphicon glyphicon-shopping-cart"> </span>Add to Cart</a>

				</c:otherwise>

			</c:choose>


			<a href="javascript:history.back()" class="btn btn-primary"><span
				class="glyphicon  glyphicon-arrow-left"> </span>Back</a>
			<hr />



		</div>

	</div>



</div>