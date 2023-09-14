package com.noej.apr282ucr.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UCRMain {
	public static void main(String[] args) {
		// Robot객체 기본생성
		// 마우스를 1900, 20으로 옮기기
		try {
			Robot r = new Robot(); // 키보드, 마우스 움직임 제어

//			r.mouseMove(1900, 10);
//			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			r.mouseMove(500, 500);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			r.keyPress(KeyEvent.VK_0);
			r.keyRelease(KeyEvent.VK_0);
			Thread.sleep(300);
			
			r.keyPress(KeyEvent.VK_1);
			r.keyRelease(KeyEvent.VK_1);
			Thread.sleep(300);
			
			r.keyPress(KeyEvent.VK_2);
			r.keyRelease(KeyEvent.VK_2);
			Thread.sleep(300);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
