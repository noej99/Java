package com.noej.apr261uch.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 1) http://openapi.seoul.go.kr:8088/(인증키)/xml/CardSubwayStatsNew/1/5/20151101
// 2) XML파싱
// 3) 파일에
// 4) 전체 다
// 5) ...

// XML : 국제표준포맷 - utf-8이 약속

// 1) 전세계적으로 많이
// 2) 리눅스+하둡 : utf-8

public class UCHMain3 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("C:\\noej\\sourceFile\\seoulSubway.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			String date;
			String s;

			for (int y = 2015; y < 2023; y++) {

				for (int m = 1; m < 13; m++) {

					for (int d = 1; d < 32; d++) {
						date = String.format("%d%02d%02d", y, m, d);

						s = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/CardSubwayStatsNew/1/610/"
								+ date;
						URL u = new URL(s);
						huc = (HttpURLConnection) u.openConnection();
						InputStream is = huc.getInputStream();

						XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
						XmlPullParser xpp = xppf.newPullParser();
						xpp.setInput(is, "utf-8");

						int type = xpp.getEventType(); // 시작태그 or 텍스트 or 종료태그
						String tagName = null;
						String when = null;
						while (type != XmlPullParser.END_DOCUMENT) {
							if (type == XmlPullParser.START_TAG) {
								tagName = xpp.getName();
							} else if (type == XmlPullParser.TEXT) {
								if (tagName.equals("USE_DT")) {
									when = xpp.getText();
									bw.write(when.substring(0, 4) + ",");
									bw.write(when.substring(4, 6) + ",");
									bw.write(when.substring(6, 8) + ",");
								} else if (tagName.equals("LINE_NUM")) {
									bw.write(xpp.getText() + ",");
								} else if (tagName.equals("SUB_STA_NM")) {
									bw.write(xpp.getText() + ",");
								} else if (tagName.equals("RIDE_PASGR_NUM")) {
									bw.write(xpp.getText() + ",");
								} else if (tagName.equals("ALIGHT_PASGR_NUM")) {
									bw.write(xpp.getText() + "\r\n");
								}
							} else if (type == XmlPullParser.END_TAG) {
								tagName = "";
							}
							xpp.next();
							type = xpp.getEventType();
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
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
