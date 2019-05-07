package com.constants;

import com.utils.PropertyUtil;

public class CommonConstants {
	public static final int DEFAULT_WEBDRIVER_TIMEOUT = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "webdriver.default.time"));
	public static final int DEFAULT_IMPLICIT_TIMEOUT = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "implicit.default.time"));
	public static final String EXTENT_REPORT = PropertyUtil.getProp("src/test/resources/properties/config.properties", "reportConfigPath");
	public static final int DEFAULT_WAIT_FOR_ELEMENT = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "implicit.default.time"));
	public static final int DEFAULT_TIMEOUT_IMPLICITWAIT= Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "default.timeout.implicitwait"));
	public static final int DEFAULT_WAIT_FOR_PAGE = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "default.wait.for.page"));
	
	/*-----SOURCE-----*/
	public static final String SOURCE_NAGIOS_PET = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "filter.Source.Nagios-Pet");
	public static final String SOURCE_CISCO_MERAKI = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "filter.Source.CiscoMeraki");
	
	/*-----EXTENDED RULES-----*/
	public static final String EXTENDED_RULE_CORRELATION = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "extendedRule.Correlation");
	public static final String EXTENDED_RULE_SUPPRESSION = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "extendedRule.Suppression");
	public static final String EXTENDED_RULE_CISCO_MERAKI_CHECK = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "extendedRule.CiscoMerakiCheck");
	public static final String EXTENDED_RULE_SNOW_DUPLICATE = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "extendedRule.SNOWDuplicate");
	
	/*-----ACTIONS-----*/
	public static final String ACTION_SEND_TO_SLACK = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendToSlack");
	public static final String ACTION_CREATE_JIRA_TICKET = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket");
	public static final String ACTION_CREATE_SNOW_TICKET = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket");
	public static final String ACTION_SEND_EMAIL = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendEmail");
	public static final String ACTION_VOID = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.Void");
	
	/*-----SLACK FIELDS-----*/
	public static final String SLACK_CHANNEL = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendToSlack.Channel");
	
	/*-----JIRA FIELDS-----*/
	public static final String JIRA_ASSIGNEE = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Assignee");
	public static final String JIRA_SLACK_CHANNEL = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.SlackChannel");
	
	/*-----SNOW FIELDS-----*/
	public static final String SNOW_IMPACTED_USER = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.ImpactedUser");
	public static final String SNOW_ASSIGNMENT_GROUP = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.AssignmentGroup");
	public static final String SNOW_ASSIGNED_TO = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.AssignedTo");
	public static final String SNOW_CATEGORY = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Category");
	public static final String SNOW_SUB_CATEGORY = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.SubCategory");
	public static final String SNOW_AREA = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Area");
	
	/*-----EMAIL FIELDS-----*/
	public static final String EMAIL_TO = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendEmail.To");
	
}
