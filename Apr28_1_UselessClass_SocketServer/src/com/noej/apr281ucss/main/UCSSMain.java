package com.noej.apr281ucss.main;

import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 서버

// 폰끼리 전화

// 전화번호 필요

// 통화서비스만 가능

// 컴끼리 통신

// IP주소 필요(전화번호 같은거)

// port번호 필요(어떤 서비스를 이용할지)

// port번호 두자리까지 약속되어있는게 많아서 - 4자리

// 시작 - cmd - ipconfig

// 이더넷 어댑터쪽의 IPv4주소 확인 : 195.168.9.61 (sub)

public class UCSSMain {

	public static void main(String[] args) {

		ServerSocket ss = null;

		Scanner k = new Scanner(System.in);

		try {

			ss = new ServerSocket(8282); // 8282번 포트로 소켓서비스 시작

			System.out.println("서버 시작");

			System.out.println("접속 기다리는중");

			Socket s = ss.accept(); // 기다리고 있다가 누가 접속하면 연결

			System.out.println("서 : 누가 접속함");

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
					jf.setVisible(true);
					while (true) {
						try {
							jta.append(br.readLine() + "\r\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();

			while (true) {

				System.out.println(br.readLine());

				System.out.println("나 : ");

				String msg = k.next();

				bw.write(msg + "\r\n");

				bw.flush();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		k.close();

		try {

			ss.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}