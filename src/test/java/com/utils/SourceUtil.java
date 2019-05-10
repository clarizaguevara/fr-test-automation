package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SourceUtil {
	
	private static final Logger log = LogManager.getLogger(SourceUtil.class);
	
	/**
     * Convert Source name to their corresponding shortnames
     */
    public String convertSourceName(String source) {
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
		System.out.println(source_shortname);
    	log.exit();
    	return source_shortname;
    }

}
