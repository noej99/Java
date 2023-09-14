package com.noej.apr261uch.main;

public class StringCleaner {
	public static String clean(String s) {
		s = s.replaceAll("&amp;quot;", "");
		s = s.replaceAll("&lt;b&gt;", "");
		s = s.replaceAll("&apos;", "");
		s = s.replaceAll("&lt;/b&gt;", "");
		s = s.replaceAll("<b>", "");
		s = s.replaceAll("</b>", "");
		s = s.replaceAll("&amp;", "");
		s = s.replaceAll("&quot;", "");
		
		return s;
	}
}
