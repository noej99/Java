package com.noej.apr261uch.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 로그인 -> 신청
// 정부사이트
//		data.go.kr
//		data.seoul.go.kr
//		data.gg.go.kr
// 포털사이트/SNS : 개발자센터
// ...
// 575a4655496b636839386f58586542
// http://openAPI.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/5/

// 1) HTTP통신수행해서 다 콘솔에 출력
// 2) XML파싱
// ------------
// 3) csv파일에
//		2023,04,26,12
public class UCHMain {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;

		try {
			URL u = new URL("http://openAPI.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/5/");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			FileOutputStream fos = new FileOutputStream("C:\\Users\\Public\\dust.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			String tagName = null;
			int what = xpp.getEventType(); // 시작태그 or 텍스트 or 종료태그
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH,");
			String when = sdf.format(new Date());
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("MSRRGN_NM")) {
						bw.write(when);
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("MSRSTE_NM") || tagName.equals("PM10") || tagName.equals("PM25")) {
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("IDEX_NM")) {
						bw.write(xpp.getText() + "\r\n");
						bw.flush();
					}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
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
