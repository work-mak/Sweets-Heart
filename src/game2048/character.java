package game2048;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class character extends character_data{

	private JFrame frame;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					character window = new character(1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public character(int characterOpen) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.getContentPane().setLayout(null);
		Image menu = new ImageIcon(this.getClass().getResource("/game_menu.png")).getImage();
	
		JLabel Menu = new JLabel();
		Menu.setBounds(1181, 628, 319, 155);
		frame.getContentPane().add(Menu);
		Menu.setIcon(new ImageIcon(menu));
		Menu.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				try {
					home GoMenu = new home();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				frame.dispose();
				frame.setVisible(false);

			}
		});
		
		JLabel bg_character = new JLabel();
		bg_character.setBounds(0, 0, 1500, 800);
		bg_character.setIcon(new ImageIcon(imageGame(characterOpen)));
		frame.getContentPane().add(bg_character);
	}


}
