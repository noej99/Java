package com.noej.apr281ucsc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 클라이언트

// 195.168.9.62 (main)
public class UCSCMain {
	public static void main(String[] args) {
		Socket s = null;
		Scanner k = new Scanner(System.in);
		try {
			// s = new Socket("195.168.9.62", 8282);
			s = new Socket("195.168.9.62", 8282);
			System.out.println("클 : 접속성공");

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			new Thread() {
				public void run() {
					JFrame jf = new JFrame();
					JTextArea jta = new JTextArea();
					jf.add(jta);
					jf.setSize(300, 500);
					jf.setLocation(300, 0);
					jf.setVisible(true);
					while (true) {
						try {
							jta.append(br.readLine()+"\r\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
			
			while (true) {
				System.out.println("나 : ");
				String msg = k.next();
				bw.write(msg + "\r\n");
				bw.flush();

				System.out.println(br.readLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		k.close();
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
