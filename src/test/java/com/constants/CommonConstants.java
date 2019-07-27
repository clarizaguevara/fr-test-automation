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
	public static final String SLACK_MENTION = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendToSlack.Mention");
	
	/*-----JIRA FIELDS-----*/
	public static final String JIRA_ASSIGNEE = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Assignee");
	public static final String JIRA_PROJECT_TYPE_ACPF = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.ProjectType.Task");
	public static final String JIRA_PLATFORM = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Platform");
	public static final String JIRA_PROGRESS = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Progress");
	public static final String JIRA_MARKET = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Market");
	public static final String JIRA_PRIORITY_ACPF = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Priority.ACPF");
	public static final String JIRA_PRIORITY_KKA = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Priority.KKA");
	public static final String JIRA_ASSIGNEE_NOT_EXISTING = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Assignee.NotExisting");
	public static final String JIRA_WATCHERS = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Watchers");
	public static final String JIRA_WATCHERS_ANOTHER = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Watchers.Another");
	public static final String JIRA_LABEL_ANOTHER = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Label.Multiple");
	public static final String JIRA_BRAND = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateJiraTicket.Brand");
	
	/*-----SNOW FIELDS-----*/
	public static final String SNOW_IMPACTED_USER = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.ImpactedUser");
	public static final String SNOW_ASSIGNMENT_GROUP = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.AssignmentGroup");
	public static final String SNOW_ASSIGNED_TO = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.AssignedTo");
	public static final String SNOW_CATEGORY = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Category");
	public static final String SNOW_SUB_CATEGORY = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.SubCategory");
	public static final String SNOW_AREA = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Area");
	public static final String SNOW_LANGUAGE = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Language");
	public static final String SNOW_CONTACT_TYPE = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.ContactType");
	public static final String SNOW_IMPACT = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Impact");
	public static final String SNOW_URGENCY = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Urgency");
	public static final String SNOW_PRIORITY = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.CreateSNOWTicket.Priority");
	
	/*-----EMAIL FIELDS-----*/
	public static final String EMAIL_TO = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendEmail.To");
	public static final String EMAIL_CC = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendEmail.CC");
	public static final String EMAIL_BCC = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendEmail.BCC");
	public static final String EMAIL_TO_SUBDOMAIN = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "action.SendEmail.To.Subdomain");

	/*-----KEYWORD LISTS-----*/
	public static final String KEYWORD_LISTNAME = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "keyword.ListName");
	public static final String KEYWORD_KEYWORDVALUE = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "keyword.KeywordValue");
	public static final String KEYWORD_LISTNAME_EDITED = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "keyword.ListName.Edited");
	
	/*-----EVENT-----*/
	public static final String EVENT_ID = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "event.EventId");
	public static final String EVENT_ID_FAILED_STATUS = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "event.EventId.FailedStatus");
	public static final String MULTIPLE_EVENT_IDS_FAILED_STATUS = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "event.MultipleEventIds.FailedStatus");
	public static final String EVENT_ID_DESELECT = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "event.EventId.Deselect");
	
	/*-----LIST OF VALUES-----*/
	public static final String LOV_KEYWORD_EMAIL = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "LOV.keyword.source-email");
	public static final String LOV_KEYWORD_NP = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "LOV.keyword.source-np");
	public static final String LOV_KEYWORD_CM = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "LOV.keyword.source-cm");
	public static final String LOV_COMPARATOR = PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "LOV.comparator");
}
