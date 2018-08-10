package net.kzn.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "La página no Existe!");
		mv.addObject("errorDescription", "La página no esta condiponible por el momento.");
		mv.addObject("title", "404 Error de Página");

		return mv;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Producto no disponible!");
		mv.addObject("errorDescription", "El producto buscado no esta disponible por el momento");
		mv.addObject("title", "404 Error de Página");

		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Contacta a tu administrador");

//		Solo para debugear tu aplicacion 
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);

		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "Error");

		return mv;
	}
}
