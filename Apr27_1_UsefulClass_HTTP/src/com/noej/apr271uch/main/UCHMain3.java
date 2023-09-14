package com.noej.apr271uch.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 2015/01/01~2022/12/31
//		2015,01,01,100번,명륜3가,성대입구,108,103

// 통신
//		HTTP통신 _ 과정 전체를 관통
//		Socket통신

// http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/JSON/CardBusStatisticsServiceNew/1/5/20151101/
public class UCHMain3 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			String year = "2019";
			FileOutputStream fos = new FileOutputStream("C:\\noej\\sourceFile\\busData" + year + ".csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			String date;

			for (int m = 1; m < 13; m++) {
				for (int d = 1; d < 32; d++) {
					for (int j = 1; j < 42000; j += 1000) {
						date = String.format("%s%02d%02d",year , m, d);
						String ss = String.format("%d/%d/%s/", j, j + 999, date);

						String s;
						System.out.println(ss);
						s = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/JSON/CardBusStatisticsServiceNew/"
								+ ss;
						URL u = new URL(s);
						huc = (HttpURLConnection) u.openConnection();

						InputStream is = huc.getInputStream();
						InputStreamReader isr = new InputStreamReader(is, "utf-8");

						JSONParser jp = new JSONParser();
						JSONObject busData = (JSONObject) jp.parse(isr);
						JSONObject jo = (JSONObject) busData.get("CardBusStatisticsServiceNew");
						if (jo != null) {

							JSONArray row = (JSONArray) jo.get("row");
							JSONObject station = null;

							// ? -> String
							// 1) 공통적인 형변환 스타일
							// String use_dt = (String) station.get("USE_DT");
							// 2) toString() 메소드 활용
							// 3) + 연산자 활용
							for (int i = 0; i < row.size(); i++) {
								station = (JSONObject) row.get(i);
								String use_dt = station.get("USE_DT") + "";
								bw.write(use_dt.substring(0, 4) + ",");
								bw.write(use_dt.substring(4, 6) + ",");
								bw.write(use_dt.substring(6, 8) + ",");
								bw.write(station.get("BUS_ROUTE_NM") + ",");
								bw.write(station.get("BUS_STA_NM") + ",");
								bw.write(station.get("RIDE_PASGR_NUM").toString().replace(".0", "") + ",");
								bw.write(station.get("ALIGHT_PASGR_NUM").toString().replace(".0", "") + "\r\n");
								bw.flush();
							}
						}
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
