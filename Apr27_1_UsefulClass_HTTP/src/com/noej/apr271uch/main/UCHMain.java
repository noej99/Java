package com.noej.apr271uch.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 데이터를 주고 받는데
// A -> B
// B의 입장에서 받은거 써먹으려면 파싱
// A랑 B 사이의 통일된 형식이 필요할거고
// XML : 데이터를 HTML형식으로 표현
// JSON : 데이터를 Javascript형식으로 표현
//		요즘 JSON이 주력, XML은 구하기도 힘든
//		=> JSON파싱 중요

// XML시스템의 원래 주인
//		AJAX : Javascript에서 XML파싱
//		Java에서 XML파싱

// https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}

// /주소명/
// api.openweathermap.org

// 폴더/.../파일
// data/2.5/weather

// 구분자
// ?

// 파라메터
// appid=키&q=도시명(시)&units=metric%lang=kr

// 화씨

// https://api.openweathermap.org/data/2.5/weather?appid=baff8f3c6cbc28a4024e336599de28c4&q=seoul&units=metric&lang=kr

// baff8f3c6cbc28a4024e336599de28c4

// XML(eXtended Markup Language)
// JSON(JavaScript Object Notation)
//		Java
//			object o = new objext();
//			o.setName("객체");

//			int[] ar = { 1, 2, 3 };

//		JavaScript
//			var d = { name : "객체", age : 3 };

//			var ar =[ 1, 2, 3 ];

// HTTP통신
// JSON파싱 : Java에는 없음
// XML파싱 : 하나씩불러서 구식
public class UCHMain {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			URL u = new URL(
					"https://api.openweathermap.org/data/2.5/weather?appid=baff8f3c6cbc28a4024e336599de28c4&q=seoul&units=metric&lang=kr");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// BufferedReader br = new BufferedReader(isr);
			// System.out.println(br.readLine());
			// json-simple.jar
			JSONParser jp = new JSONParser();
			// jp.parse(br.readLine());
			JSONObject jo = (JSONObject) jp.parse(isr); // 전체 다 불러오기
			// JSONArray ja = (JSONArray)jp.parse(isr);
			// 객체 {로 시작
			// 배열 [로 시작

			JSONArray ja = (JSONArray) jo.get("weather");
			JSONObject a = (JSONObject) ja.get(0);
			JSONObject b = (JSONObject) jo.get("main");

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH,");
			String d2 = sdf.format(d);

			System.out.print(d2);
			System.out.print(a.get("description") + ",");
			System.out.print(b.get("temp") + ",");
			System.out.print(b.get("humidity") + "\r\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
