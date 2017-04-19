package com.optus.truncate.util;

import org.springframework.stereotype.Component;

@Component
public class MyTruncatePattern implements TruncatePattern{

	private final String PATTERN = " ... (truncated) ... ";
	
	@Override
	public String getPattern() {
		return PATTERN;
	}

	@Override
	public int getPatternLength() {
		return PATTERN.length();
	}

}
