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

	default:
		$("#listProducts").addClass('active');
		break;
	}

}

)
