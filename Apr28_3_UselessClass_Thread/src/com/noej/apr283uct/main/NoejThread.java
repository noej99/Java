package com.noej.apr283uct.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 1) extends Thread => 좋은 방법은 아님
public class NoejThread extends Thread {
	@Override
	public void run() {

		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		jf.setSize(300, 500);
		jf.setVisible(true);
		for (int i = 0; i < 10; i++) {
			jta.append("ㅎ\r\n");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
