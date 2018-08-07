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

}

)
