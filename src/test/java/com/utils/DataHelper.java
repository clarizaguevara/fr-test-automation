package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.CommonConstants;

public class DataHelper {
	
	private static final Logger log = LogManager.getLogger(DataHelper.class);
	
	
    /**
     * Convert Source name to their corresponding shortnames
     */
    public static String convertSourceName(String source) {
    	log.entry();
    	String source_shortname = "";
		switch(source) {
		case "Nagios-Pet": source_shortname = "NP"; break;
		case "Cisco Meraki": source_shortname = "CM"; break;
		case "Email": source_shortname = "EMAIL"; break;
		case "Email WUG": source_shortname = "E-WUG"; break;
		default: break;
		}
		//System.out.println(source_shortname);
    	log.exit();
    	return source_shortname;
    }
    
    /**
     * Format string to date or timestamp
     */
    public static Date parseDateTime(String format, String value) {
    	SimpleDateFormat sdFormat = new SimpleDateFormat(format);
    	Date formattedDate = null;
    	try {
			formattedDate = sdFormat.parse(value);
			
			log.exit();
			return formattedDate;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.exit();
			return formattedDate;
		} 
    }
    
    /**
     * Format date or timestamp to string
     */
    public static String formatDateTime(String format, Date value) {
    	SimpleDateFormat sdFormat = new SimpleDateFormat(format);
    	String formattedStr = "";
    	try {
			formattedStr = sdFormat.format(value);
			
			log.exit();
			return formattedStr;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.exit();
			return formattedStr;
		} 
    }
    
    /**
     * Convert Event Status to their corresponding color
     */
    public static String convertToStatusColor(String status) {
    	log.entry();
    	String status_color = "";
		switch(status) {
		case "Success": status_color = "green"; break;
		case "Partially Successful": status_color = "yellow"; break;
		case "Failed": status_color = "red"; break;
		default: break;
		}
		log.exit();
    	return status_color;
    }
    
    /**
     * Get the list of values
     */
    public static String getLOV(String source) {
    	log.entry();
    	String lov = "";
		switch(source) {
		case "Nagios-Pet": lov = CommonConstants.LOV_FIELDS_NP; break;
		case "Cisco Meraki": lov = CommonConstants.LOV_FIELDS_CM; break;
		case "Email": lov = CommonConstants.LOV_FIELDS_EMAIL; break;
		case "Email WUG": lov = CommonConstants.LOV_FIELDS_EMAILWUG; break;
		default: break;
		}
		log.exit();
    	return lov;
    }
    
}
