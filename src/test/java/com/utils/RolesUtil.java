package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pageobjects.AccessManagementPage;

public class RolesUtil {
	
	private static final Logger log = LogManager.getLogger(SuppressionUtil.class);
	
	/**
     * Select Roles
     */
    public void selectRoles(String roleNames, AccessManagementPage accessManagementPage) {
    	log.entry();
    	List<String> selectedRoles = new ArrayList<String>();
    	selectedRoles = Arrays.asList(roleNames.split(","));
    	
    	for (int counter = 0; counter < selectedRoles.size(); counter++) {
    		accessManagementPage.selectRoles(selectedRoles.get(counter));
    	}
    		
    }

}
