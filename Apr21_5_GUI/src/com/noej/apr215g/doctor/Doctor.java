package com.noej.apr215g.doctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Doctor implements ActionListener {
	private JTextField nt;
	private JTextField ht;
	private JTextField wt;
	private JLabel resultlb;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(JTextField nt, JTextField ht, JTextField wt, JLabel resultlb) {
		super();
		this.nt = nt;
		this.ht = ht;
		this.wt = wt;
		this.resultlb = resultlb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nt.getText();
		String height = ht.getText();
		// String -> double[다음 진도]
		double height2 = Double.parseDouble(height);
		
		String weight = wt.getText();
		double weight2 = Double.parseDouble(weight);
		
		double bmi = weight2 / ((height2 / 100) * (height2 / 100));
		String status = "저체중";
		if (bmi >= 35) {
			status = "고도 비만";
		} else if (bmi >= 30) {
			status = "중도 비만";
		} else if (bmi >= 25) {
			status = " 경도 비만";
		} else if (bmi >= 23) {
			status = "과체중";
		} else if (bmi >= 18.5) {
			status = " 정상";
		}
		// 다음진도
		String result = String.format("%.1f, %s씨는 %s", bmi,name,status);
		resultlb.setText(result);
	}
}
