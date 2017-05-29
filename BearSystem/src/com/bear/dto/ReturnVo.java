package com.bear.dto;

public class ReturnVo<T>
{
  private String code;
  private String msg;
  private T data;
  
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
  
  public T getData()
  {
    return this.data;
  }
  
  public void setData(T data)
  {
    this.data = data;
  }
  
  public ReturnVo(String code, String msg)
  {
    this.code = code;
    this.msg = msg;
  }
  
  public ReturnVo(String code, T data)
  {
    this.code = code;
    this.data = data;
  }

	public ReturnVo(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
