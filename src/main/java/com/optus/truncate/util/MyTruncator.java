package com.optus.truncate.util;

import org.springframework.stereotype.Component;

@Component
public class MyTruncator implements Truncator{

	@Override
	public String truncate(String data, int maxCharacters, TruncatePattern pattern) {		
		
		if(data == null || pattern == null || data.length() <= maxCharacters)
			return data;
		
		// Maximum number of characters should be greater than or equal to
		// pattern length + 2 (considering that at least first and last character 
		// of actual data should be present in the truncated string)
		if(maxCharacters < pattern.getPatternLength() + 2)
			return data;
		
		int charactersTokeep = maxCharacters - pattern.getPatternLength();
		
		StringBuilder result = new StringBuilder();
		
		int frontIndex = (int) Math.ceil(charactersTokeep/2.0);
		int endIndex = charactersTokeep - frontIndex;
		
		result.append(data.substring(0, frontIndex));
		result.append(pattern.getPattern());
		result.append(data.substring(data.length() - endIndex, data.length()));
		
		return result.toString();
	}

}
