package com.bear.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bear.exception.HandelException;

public class ParametersCheckUtil {

	
	public static void checkParams(Object params, String name) {
		if(params == null) {
			throw new HandelException("参数: " + name + "不能为空", -10002);
		}
	}

	
	/**
     * 验证输入的手机格式是否正确
     *
     * @param s 待验证的字符串
     * @return 是否合法 true合法
     */
    public static void mobileValidate(String phone) {
//        String strPattern = "^((\\(\\d{2,3}\\))|(\\d{3}\\-))?13\\d{9}$";
        String strPattern = "^(13|15|18|17)\\d{9}$";
        boolean bool= validate(phone, strPattern);
        if(!bool){
        	throw new HandelException("参数: " + phone + "不合法", -10003);
        }
    }

    
    /**
     * 正则验证
     *
     * @param s          待验证的字符串
     * @param strPattern 格式
     * @return 符合格式则返回true，反之返回false
     */
    private static boolean validate(String s, String strPattern) {
        if (s == null)
            return Boolean.FALSE;
        Pattern pattern = Pattern.compile(strPattern);
        Matcher mat = pattern.matcher(s);
        if (!mat.find())
            return Boolean.FALSE;
        return Boolean.TRUE;
    }
}
