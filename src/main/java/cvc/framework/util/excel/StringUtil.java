﻿package cvc.framework.util.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static boolean IsNullOrEmpty(String s) {
		if (s == null || s.isEmpty())
			return true;
		return false;
	}
	
	
	public static String getDateString(String format)
	{
		
		Date d = new Date();
		if(StringUtil.IsNullOrEmpty(format))
		{
			format="yyyy-MM-dd HH:mm:ss";		//yyyy-MM-dd HH:mm:ss
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		 
		String s=sdf.format(d);
		return s;
	}

	public static String format(String format, Object... arguments) {
		if (arguments.length > 0) {
			String result = format;
			for (int i = 0; i < arguments.length; i++) {
				if (arguments[i] == null) 
				{
					return "";
				}
				else 
				{
					String reg = "{" + i + "}";
					result = result.replace(reg,arguments[i].toString());
				}
			}
			return result;
		} else {
			return format;
		}
	}
	
	
	public static String toString(Object object)
	{
		if(object==null)
			return "";
		if(object.equals("null"))
			return "";
		return object.toString();
	}
	
	public static int Indexof(String []arr,String value)
	{
		
		if(arr!=null&&arr.length>0)
		{
			 for(int k=0;k<arr.length;k++)
			 {
				 if(value.equals(arr[k]))
				 {
					 return k;
				 }
			 }
			
		}
		return -1;
	}
	
	
	public static String replaceBlank(String str) 
	{

		String dest = "";

		if (str != null) {

			Pattern p = Pattern.compile("\\s*|\t|\r|\n");

			Matcher m = p.matcher(str);

			dest = m.replaceAll("");

		}

		return dest;
	}
	public static String getFileNameByUrl(String targeturl)
	{
		int index=targeturl.lastIndexOf("/");
		if(index>=0)
		{
			String url=targeturl.substring(index+1);
			return url;
		}
		return "";
	}

}
