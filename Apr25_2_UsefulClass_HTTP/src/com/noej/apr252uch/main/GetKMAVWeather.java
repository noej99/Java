package com.noej.apr252uch.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 1) 오늘 것만 나오게 
// 2) kmaWeather.csv에
//		2023.04.26
public class GetKMAVWeather {
	public static void main(String[] args) {

		HttpsURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			// 기껏 파일 열어놨는데 기상청에 접속이 안되서 실패
			// 기상청 접속 안되면 파일도 안열리게

			// 기상청 - 실패 확률이 꽤
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1126058000";
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			// 파일 열기 - 거의 성공
			FileOutputStream fos = new FileOutputStream("C:\\noej\\sourceFile\\kmaWeather.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			///////////////////////////////////////
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			String tagName = null;
			int what = xpp.getEventType(); // 지금 가져온게 셋 중에 무엇
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,");
			String now2 = sdf.format(now);
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						if (xpp.getText().equals("3")) {
							break;
						}
						bw.write(now2);
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("temp")) {
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("wfKor")) {
						bw.write(xpp.getText() + "\r\n");
						System.out.println("---------");
					}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
					// tagName = null;
				}
				xpp.next();
				what = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
