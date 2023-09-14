package com.noej.apr252uch.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class Test {
	public static void main(String[] args) {

		HttpsURLConnection huc = null;
		try {
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1126058000";
			URL u = new URL(s);
			// HttpURLConnection = (HttpURLConnection) u.openConnection();
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			// xpp.setInput(isr);
			int what = xpp.getEventType();	// 지금 가져온게 셋 중에 무엇
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					// System.out.println(xpp.getName());
				} else if (what == XmlPullParser.TEXT) {
					// System.out.println(xpp.getText());
				} else if (what == XmlPullParser.END_TAG) {
					// System.out.println(xpp.getName());
				}
				xpp.next();
				what = xpp.getEventType();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
