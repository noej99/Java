package com.noej.apr215g.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.noej.apr215g.doctor.Doctor;

// JFrame : 윈도우프로그램 바탕이 되는 판[행성]
// Layout : 입주전략
public class GMain {
	public static void main(String[] args) {

		JFrame jf = new JFrame("비만도 검사");

		// 4행 2열
		GridLayout gl = new GridLayout(4, 2);
		jf.setLayout(gl);

		// 텍스트가 이름 : 인 JLabel
		// jf에 추가

		jf.add(new JLabel("이름: "));
		JTextField nt = new JTextField(null);
		jf.add(nt);

		jf.add(new JLabel("키 : "));
		JTextField ht = new JTextField(null);
		jf.add(ht);

		jf.add(new JLabel("몸무게 : "));
		JTextField wt = new JTextField(null);
		jf.add(wt);

		JLabel result = new JLabel("결과");
		jf.add(result);
		JButton jb = new JButton("확인");
		jf.add(jb);

		Doctor d = new Doctor(nt, ht, wt, result);
		jb.addActionListener(d);
		
		jf.setSize(300, 350);
		jf.setVisible(true);
	}
}
