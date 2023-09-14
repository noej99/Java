package com.noej.may021ucc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// 2015/0101~2022/12/31까지 서울 지하철 운행정보
// 노선별로 이용객수 합계
//		3호선 -> ????

public class UCCMain3 {
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			FileInputStream fis = new FileInputStream("C://noej//sourceFile//seoulSubway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line = null;
			String[] line2 = null;
			long sum = 0; // 범위가 커서 int보다 범위가 넓은 long사용
			HashMap<String, Long> hm = new HashMap<>();

			while ((line = br.readLine()) != null) {
				line2 = line.split(",");
				sum = Long.parseLong(line2[5]) + Long.parseLong(line2[6]);

				if (hm.containsKey(line2[3])) {
					hm.put(line2[3], hm.get(line2[3]) + sum);
				} else {
					hm.put(line2[3], sum);
				}
			}

			Set<String> no = hm.keySet();
			ArrayList<String> no2 = new ArrayList<>(no);
			for (String n : no2) {
				System.out.println(n);
				System.out.println(hm.get(n));
				System.out.println("-----------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
