$(function() {
	// solving the active menu

	switch (menu) {
	case 'About Us':
		$("#about").addClass('active');
		break;
	case 'Contact Us':
		$("#contact").addClass('active');
		break;

	case 'Todos los Productos':
		$("#listProducts").addClass('active');
		break;

	case 'Home':
		break;

	default:

		$("#listProducts").addClass('active');
		$("#a_" + menu).addClass('active');
		break;
	}

	// codigo para jquery dataTable

	var $table = $('#productListTable');

	// ejecutar el codido de abajo solo cuando tengamos esta table

	if ($table.length) {
		console.log('Dentro de la tabla');

		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Recrods', 'ALL' ] ],
					language : {
						"url" : "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
					},
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';

								}

							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return 'S/. ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Sin stock! <span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {

										str += '<a href="javascript.void(0);" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/show/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									}

									return str;
								}
							} ]
				})
	}
}

)
