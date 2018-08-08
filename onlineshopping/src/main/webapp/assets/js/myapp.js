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
	// create a dataset

	var products = [ [ '1', 'ABC' ], [ '2', 'SDC' ], [ '3', 'XSD' ],
			[ '4', 'SFD' ], [ '5', 'SAF' ], [ '6', 'HFD' ], [ '7', 'UTY' ],
			[ '8', 'ERS' ] ];

	var $table = $('#productListTable');
	
	// ejecutar el codido de abajo solo cuando tengamos esta table
	
	if($table.length){
		console.log('Dentro de la tabla');
		
		$table.DataTable({
			lengthMenu : [[3,5,10,-1],['3 Records','5 Records','10 Recrods','ALL']],
			data : products
		})
	}
}

)
