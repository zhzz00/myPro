package com.bear.dto;

public class ExceptionRsp
{
  private Integer code;
  private String msg = "";
  
  public ExceptionRsp() {}
  
  public ExceptionRsp(int code, String msg)
  {
    this.code = Integer.valueOf(code);
    this.msg = msg;
  }
  
  public Integer getCode()
  {
    return this.code;
  }
  
  public void setCode(int code)
  {
    this.code = Integer.valueOf(code);
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
}
