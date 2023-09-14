package com.noej.apr214os.main;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.noej.apr214os.hero.Herk;

// 

// awt/swing(Java GUI프로그래밍)
//		1) 웹기반으로 바꾸는 중
//		2) 윈도우프로그램 : C# -> WinSDK
//		3) 웹, BD/AI에 1도 도움이 안됨 : Android에는 도움이 되는데
public class OMain2 {
	public static void main(String[] args) {
		// 제목이 지구인 JFrame
		JFrame jf = new JFrame("지구");
		
		// 텍스트가 홍길동인 JButton
		JButton h = new JButton("홍길동");
		// 저 JFrame에 JButton추가
		jf.add(h);
		
		// 이벤트 처리를 하자
		// 반드시 attack()이 필요	: Hero interface[사수]
		// 반드시 actionPerformed()	: ActionList[Java]
		
		// 영웅인 아이언맨
		// ActionListener인 헐크
		Herk i = new Herk();

		// 저 JButton이 담당 ActionListener로 헐크를 찜
		h.addActionListener(i);
		
		// 도움요청 -> 클릭
		
		
		// 그 JFrame 사이즈가 500, 300
		jf.setSize(500, 300);
		
		// 그 JFrame 보이게
		jf.setVisible(true);

		// 텍스트가 홍길동인 JTextField
		JTextField f = new JTextField("김길동");
//		jf.add(f);
		
		JFileChooser c = new JFileChooser();
//		jf.add(c);
		
	}
}
