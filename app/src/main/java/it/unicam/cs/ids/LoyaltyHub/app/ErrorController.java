package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
 /*
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }
 
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundException(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        modelAndView.addObject("errorMessage", "Page not found");
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }
    */
}