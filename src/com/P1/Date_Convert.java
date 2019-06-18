package com.P1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Convert {


public String dateConvert(String str) throws ParseException {
	
    String str1=str.replace(" ","-");
	
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMMM-yyyy");
    
    Date date = null;
    
    date=format2.parse(str1);
    String dateString = format1.format(date);
    return dateString;
}
}


