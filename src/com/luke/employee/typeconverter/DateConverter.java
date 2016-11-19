package com.luke.employee.typeconverter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter{
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Object convertFromString(Map arg0, String[] values, Class toClass) {
		if(toClass == Date.class){
			try {
				return formatter.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object inClass) {
		if(inClass instanceof Date){
			return formatter.format(inClass);
		}
		return null;
	}

}
