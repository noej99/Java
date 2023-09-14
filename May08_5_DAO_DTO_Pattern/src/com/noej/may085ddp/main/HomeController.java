package com.noej.may085ddp.main;


// DAO/DTO패턴

// 수많은 메이커들마다 
// OracleDB랑 연결해야 하니 OracleDriver가 필요 : ojdbc8.jar

// 어차피 DB랑 연결/끊고는 매번하는거고
// 라이브러리로 만들어놨고

// PL급
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		Gift g = cs.getInput();
		String result = GiftDAO.reg(g);
		cs.print(result);
		cs.bye();
		
	}
}
