package com.bear.exception;

public class HandelException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private Integer code;
  
  public HandelException() {}
  
  public HandelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code)
  {
    this.code = Integer.valueOf(code);
  }
  
  public HandelException(String message, Throwable cause, int code)
  {
    super(message, cause);
    this.code = Integer.valueOf(code);
  }
  
  public HandelException(String message, int code)
  {
    super(message);
    this.code = Integer.valueOf(code);
  }
  
  public HandelException(Throwable cause, int code)
  {
    super(cause);
    this.code = Integer.valueOf(code);
  }
  
  public Integer getCode()
  {
    return this.code;
  }
  
  public void setCode(int code)
  {
    this.code = Integer.valueOf(code);
  }
}
