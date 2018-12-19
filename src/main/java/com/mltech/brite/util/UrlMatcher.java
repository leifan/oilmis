package com.mltech.brite.util;

public interface UrlMatcher {
	Object compile(String paramString);

	boolean pathMatchesUrl(Object paramObject, String paramString);

	String getUniversalMatchPattern();

	boolean requiresLowerCaseUrl();
}
