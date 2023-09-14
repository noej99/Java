package com.noej.apr271uch.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 위도 : 37.579617!
// 경도 : 126.977041!

// restful
// 5ab3f6c958807e1fa13b50555c88d2c3

// 프로토콜://Host/폴더/폴더/.../파일명
public class UCHMain2 {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		Scanner k = new Scanner(System.in);
		try {
			System.out.println("검색 : ");
			String what = k.next();
			what = URLEncoder.encode(what, "utf-8");

			String s = "https://dapi.kakao.com//v2//local//search//keyword.json";
			s += "?x=126.977041&y=37.579617&radius=3000&query=" + what;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 5ab3f6c958807e1fa13b50555c88d2c3");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// BufferedReader br = new BufferedReader(isr);
			// System.out.println(br.readLine());

			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONArray ja = (JSONArray) jo.get("documents");

			for (int i = 0; i < ja.size(); i++) {
				JSONObject documents = (JSONObject) ja.get(i);

				System.out.println(documents.get("place_name"));
				System.out.println(documents.get("road_address_name"));
				System.out.println(documents.get("phone"));
				System.out.println(documents.get("distance"));
				System.out.println("----------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		k.close();
		huc.disconnect();
	}
}
