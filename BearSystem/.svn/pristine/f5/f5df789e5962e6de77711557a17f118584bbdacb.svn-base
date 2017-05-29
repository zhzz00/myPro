package com.bear.web;
import com.bear.dto.ExceptionRsp;
import com.bear.exception.HandelException;
import com.bear.intercepter.StringEscapeEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController
{
  private Logger log = LoggerFactory.getLogger(getClass());
  
  @InitBinder
  public void initBinder(ServletRequestDataBinder binder)
  {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    



    binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
  }
  
  @ExceptionHandler
  @ResponseBody
  public Object exceptionHandel(Exception ex)
  {
    this.log.error("interface exception", ex);
    ExceptionRsp rsp = null;
    if ((ex instanceof HandelException))
    {
      HandelException bse = (HandelException)ex;
      rsp = new ExceptionRsp(bse.getCode().intValue(), bse.getMessage());
    }
    else
    {
      rsp = new ExceptionRsp(-9999, "系统错误");
    }
    return rsp;
  }
}
