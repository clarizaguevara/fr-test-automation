package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		case "Email - JP1": source_shortname = "E-JP1"; break;
		case "Email - Nagios-Pet": source_shortname = "E-NP"; break;
		case "Email - WhatsUp Gold": source_shortname = "E-WUG"; break;
		default: break;
		}
		//System.out.println(source_shortname);
    	log.exit();
    	return source_shortname;
    }
    
    /**
     * Check if date selected is in range
     */
    public static boolean isDateInRange(String date, String timestampFrom, String timestampTo) {
    	log.entry();
    	boolean isDateInRange = true;
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
    	SimpleDateFormat timestampFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
    	try {
			Date dtToCompare = dateFormat.parse(date);
			Date dtTimestampFrom = timestampFormat.parse(timestampFrom);
			Date dtTimestampTo = timestampFormat.parse(timestampTo);
			
			//System.out.println(dtToCompare + " >= " + dtTimestampFrom + " && " + dtToCompare + " <= " + dtTimestampTo);
			isDateInRange = dtToCompare.compareTo(dtTimestampFrom) >= 0 && dtToCompare.compareTo(dtTimestampTo) <= 0;
			
			log.exit();
			return isDateInRange;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.exit();
			return isDateInRange = false;
		} 
    	
    }
    
    /**
     * Compare two dates
     */
    public static boolean compareDates(String dateFrom, String dateTo) {
    	log.entry();
    	boolean isFromNotGreaterThanTo = true;
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	try {
			Date dtDateFrom = dateFormat.parse(dateFrom);
			Date dtDateTo = dateFormat.parse(dateTo);
			
			isFromNotGreaterThanTo = dtDateFrom.before(dtDateTo);
			
			log.exit();
			return isFromNotGreaterThanTo;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.exit();
			return isFromNotGreaterThanTo = false;
		} 
    	
    }
    
    /**
     * Compare two timestamps
     */
    public static boolean compareTimestamps(String timestampFrom, String timestampTo) {
    	log.entry();
    	boolean isFromNotGreaterThanTo = true;
    	SimpleDateFormat timestampFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
    	try {
			Date dtTimestampFrom = timestampFormat.parse(timestampFrom);
			Date dtTimestampTo = timestampFormat.parse(timestampTo);
			
			isFromNotGreaterThanTo = dtTimestampFrom.before(dtTimestampTo);
			
			log.exit();
			return isFromNotGreaterThanTo;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.exit();
			return isFromNotGreaterThanTo = false;
		} 
    	
    }
    
}
