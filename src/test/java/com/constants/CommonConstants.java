package com.constants;

import com.utils.PropertyUtil;

public class CommonConstants {
	public static final int DEFAULT_WEBDRIVER_TIMEOUT = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "webdriver.default.time"));
	public static final int DEFAULT_IMPLICIT_TIMEOUT = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "implicit.default.time"));
	public static final String EXTENT_REPORT = PropertyUtil.getProp("src/test/resources/properties/config.properties", "reportConfigPath");
	public static final int DEFAULT_WAIT_FOR_ELEMENT = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "implicit.default.time"));
	public static final int DEFAULT_TIMEOUT_IMPLICITWAIT= Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "default.timeout.implicitwait"));
	public static final int DEFAULT_WAIT_FOR_PAGE = Integer.parseInt(PropertyUtil.getProp("src/test/resources/properties/config.properties", "default.wait.for.page"));
}
