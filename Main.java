package BrickBracker;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		GameDesign game=new GameDesign();
		JFrame obj=new JFrame();
		obj.setTitle("Brick Breaker game");
		obj.setBounds(100,10,700,700);
		obj.setResizable(false);
		obj.setVisible(true);
		
		obj.add(game);
		
		

	}

}
