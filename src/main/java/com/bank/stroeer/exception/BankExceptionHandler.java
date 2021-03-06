package com.bank.stroeer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public class BankExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView processException(Exception exception) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("description", exception.getMessage());
        return mv;
    }
}
