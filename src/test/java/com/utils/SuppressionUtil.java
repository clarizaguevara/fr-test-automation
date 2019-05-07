package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pageobjects.SuppressionPage;

public class SuppressionUtil {
	
	private static final Logger log = LogManager.getLogger(SuppressionUtil.class);
	
	/**
     * Enable/Disable Days in Suppression Condition
     */
    public void selectDays(String days, SuppressionPage suppressionPage) {
    	log.entry();
    	List<String> selectedDays = new ArrayList<String>();
    	ArrayList<String> defaultEnabledDays = new ArrayList<>(Arrays.asList("MON","TUE","WED","THU","FRI"));
    	ArrayList<String> defaultDisabledDays = new ArrayList<>(Arrays.asList("SAT","SUN"));
    	
    	selectedDays = Arrays.asList(days.split("\\s*,\\s*"));
    	
    	//Check selected days
    	for (int counter = 0; counter < defaultEnabledDays.size(); counter++) {
    		if(!selectedDays.contains(defaultEnabledDays.get(counter))) {
            	//Day is to disable (MON-FRI)
    			switch(defaultEnabledDays.get(counter)) {
        		case "MON": suppressionPage.selectMON(); System.out.println("Deselected MON"); break;
        		case "TUE": suppressionPage.selectTUE(); System.out.println("Deselected TUE"); break;
        		case "WED": suppressionPage.selectWED(); System.out.println("Deselected WED"); break;
        		case "THU": suppressionPage.selectTHU(); System.out.println("Deselected THU"); break;
        		case "FRI": suppressionPage.selectFRI(); System.out.println("Deselected FRI"); break;
        		case "SAT": break; //do nothing
        		case "SUN": break; //do nothing
        		default: System.out.println(defaultEnabledDays.get(counter));
    			}
    		}
    	}
    	
    	//Check selected days if it contains SAT/SUN
    	for (int ctr = 0; ctr < defaultDisabledDays.size(); ctr++) {
    		if(selectedDays.contains(defaultDisabledDays.get(ctr))) {
    			//Day is SAT/SUN. Day is to enable
    			switch(defaultDisabledDays.get(ctr)) {
        		case "MON": break; //do nothing
        		case "TUE": break; //do nothing
        		case "WED": break; //do nothing
        		case "THU": break; //do nothing
        		case "FRI": break; //do nothing
        		case "SAT": suppressionPage.selectSAT(); System.out.println("Selected SAT"); break;
        		case "SUN": suppressionPage.selectSUN(); System.out.println("Selected SUN"); break;
        		default: System.out.println(defaultDisabledDays.get(ctr));
        		}
    		}
    	}
    	log.exit();
    }
    
    /**
     * Select Time in Suppression Condition
     */
    public void selectTime(String timeFrom, String timeTo, SuppressionPage suppressionPage) {
    	log.entry();
    	
    	List<String> time_From = Arrays.asList(timeFrom.split(":"));
    	List<String> time_To = Arrays.asList(timeTo.split(":"));
    	
    	System.out.println(time_From.get(0));
    	System.out.println(time_From.get(1));
    	System.out.println(time_To.get(0));
    	System.out.println(time_To.get(1));
    	
    	//Select time
    	suppressionPage.selectTimeFrom(time_From.get(0), time_From.get(1));
		suppressionPage.selectTimeTo(time_To.get(0), time_To.get(1));
		
    	log.exit();
    }
    
}
