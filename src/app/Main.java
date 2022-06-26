package app;

import exception.TerminalException;

public class Main {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		try {
			menu.menuMain();
		} catch (TerminalException e) {
			e.printStackTrace();
		}
		
	}
}
