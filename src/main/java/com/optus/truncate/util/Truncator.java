package com.optus.truncate.util;

public interface Truncator {

	String truncate(String data, int maxCharacters, TruncatePattern pattern);
}
