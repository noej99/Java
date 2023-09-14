package com.noej.apr261uch.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

//	RQ9HCQs13HBM5bGvalQW
//	NxAbRl8vDZ
// 네이버에게 검색결과 달라고 요청

// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%BB%A4%ED%94%BC

// 인터넷 주소 체계
//		프로토콜://서버주소/폴더명/폴더명/.../파일명?변수명=값&변수명=값...
//		프로토콜 - 통신방식(http or https)

// 서버측에 정보를 보내
//		request parameter - 공개적
//		request header - 보안성이 높음
// 인터넷 주소에 한글 넣으면 안됨
//		ㅋ -> %2A(URL인코딩)

// 네이버 뉴스를 파일에 기록하는 프로그램
// 1) HTTP통신 되나
public class UCHMain2 {

	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			// URL인코딩
			String q = "스포츠";
			q = URLEncoder.encode(q, "utf-8");

			URL u = new URL("https://openapi.naver.com/v1/search/news.xml?query=" + q);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "RQ9HCQs13HBM5bGvalQW");
			huc.addRequestProperty("X-Naver-Client-Secret", "NxAbRl8vDZ");
			InputStream is = huc.getInputStream();

			FileOutputStream fos = new FileOutputStream("C:\\noej\\sourceFile\\naverNews.txt", true);
			bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			int what = xpp.getEventType(); // 시작태그 or 텍스트 or 종료태그

			String tagName = null;
			boolean data = false;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("item")) {
						data = true;
					}
				} else if (what == XmlPullParser.TEXT) {
					if (data) {
						if (tagName.equals("title")) {
							bw.write(StringCleaner.clean(xpp.getText()) + "\t");
						} else if (tagName.equals("description")) {
							bw.write(StringCleaner.clean(xpp.getText()) + "\r\n");
						}
					}
				} else if (what == XmlPullParser.END_TAG) {

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
